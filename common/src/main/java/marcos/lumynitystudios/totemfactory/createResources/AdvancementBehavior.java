package marcos.lumynitystudios.totemfactory.createResources;

import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BehaviourType;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import marcos.lumynitystudios.totemfactory.ModLoaderHelper;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.*;

public class AdvancementBehavior extends BlockEntityBehaviour {
    public static final BehaviourType<AdvancementBehavior> TYPE = new BehaviourType<>();
    private UUID playerId;
    private final Set<ResourceLocation> advancements = new HashSet<>();
    public AdvancementBehavior(SmartBlockEntity be, ResourceLocation... advancements) {
        super(be);
        add(advancements);
    }

    public void add(ResourceLocation... advancements) {
        this.advancements.addAll(Arrays.asList(advancements));
    }

    public boolean isOwnerPresent() {
        return playerId != null;
    }
    public void setPlayer(UUID id) {
        ServerPlayer player = getPlayerById(id);
        if (player != null) {
            this.playerId = id;
            removeAwarded();
            blockEntity.setChanged();
        }
    }

    @Override
    public void initialize() {
        super.initialize();
        removeAwarded();
    }

    private void removeAwarded() {
        ServerPlayer player = getPlayer();
        if (player == null)
            return;

        advancements.removeIf(a -> isAwardedTo(a, player));

        if (advancements.isEmpty()) {
            playerId = null;
            blockEntity.setChanged();
        }
    }
    public void awardPlayerIfNear(ResourceLocation advancement, int maxDistance) {
        ServerPlayer player = getPlayer();
        if (player == null)
            return;

        Vec3 center = Vec3.atCenterOf(getPos());
        if (player.distanceToSqr(center) <= (double) (maxDistance * maxDistance)) {
            award(advancement, player);
        }
    }
    public void awardPlayer(ResourceLocation advancement) {
        ServerPlayer player = getPlayer();
        if (player != null) {
            award(advancement, player);
        }
    }
    private void award(ResourceLocation advancement, ServerPlayer player) {
        if (!advancements.contains(advancement))
            return;

        AdvancementHolder holder =
            player.server.getAdvancements().get(advancement);

        if (holder == null)
            return;

        AdvancementProgress progress =
            player.getAdvancements().getOrStartProgress(holder);

        if (!progress.isDone()) {
            for (String criteria : progress.getRemainingCriteria()) {
                player.getAdvancements().award(holder, criteria);
            }
        }
        removeAwarded();
    }
    private boolean isAwardedTo(ResourceLocation advancement, ServerPlayer player) {
        AdvancementHolder holder =
            player.server.getAdvancements().get(advancement);

        if (holder == null)
            return true;

        AdvancementProgress progress =
            player.getAdvancements().getOrStartProgress(holder);

        return progress.isDone();
    }

    private ServerPlayer getPlayer() {
        return playerId == null ? null : getPlayerById(playerId);
    }
    private ServerPlayer getPlayerById(UUID id) {
        Level level = getWorld();
        if (!(level instanceof ServerLevel serverLevel))
            return null;

        return serverLevel.getServer().getPlayerList().getPlayer(id);
    }

    @Override
    public void write(CompoundTag tag, HolderLookup.Provider registries, boolean clientPacket) {
        super.write(tag, registries, clientPacket);
        if (playerId != null) {
            tag.putUUID("Owner", playerId);
        }
    }
    @Override
    public void read(CompoundTag tag, HolderLookup.Provider registries, boolean clientPacket) {
        super.read(tag, registries, clientPacket);
        if (tag.hasUUID("Owner")) {
            playerId = tag.getUUID("Owner");
        }
    }
    @Override
    public BehaviourType<?> getType() {
        return TYPE;
    }

    public static void tryAward(BlockGetter reader, BlockPos pos, ResourceLocation advancement) {
        AdvancementBehavior behaviour =
            BlockEntityBehaviour.get(reader, pos, TYPE);

        if (behaviour != null) {
            behaviour.awardPlayer(advancement);
        }
    }
    public static void setPlacedBy(Level level, BlockPos pos, LivingEntity placer) {
        AdvancementBehavior behaviour =
            BlockEntityBehaviour.get(level, pos, TYPE);

        if (behaviour == null)
            return;

        if (placer instanceof ServerPlayer player && !ModLoaderHelper.isFakePlayer(player)) {
            behaviour.setPlayer(player.getUUID());
        }
    }
}
