package com.tac.guns.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.tac.guns.client.SpecialModels;
import com.tac.guns.client.render.animation.M870AnimationController;
import com.tac.guns.client.render.animation.module.PlayerHandAnimation;
import com.tac.guns.client.render.gun.IOverrideModel;
import com.tac.guns.client.util.RenderUtil;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

/*
 * Because the revolver has a rotating chamber, we need to render it in a
 * different way than normal items. In this case we are overriding the model.
 */

/**
 * Author: Timeless Development, and associates.
 */
public class m870_classic_animation implements IOverrideModel {

    @Override
    public void render(float v, ItemTransforms.TransformType transformType, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrices, MultiBufferSource renderBuffer, int light, int overlay) {
        
        M870AnimationController controller = M870AnimationController.getInstance();

        matrices.pushPose();
        {
            controller.applySpecialModelTransform(SpecialModels.M870_CLASSIC_BODY.getModel(), M870AnimationController.INDEX_BODY, transformType,matrices);
            RenderUtil.renderModel(SpecialModels.M870_CLASSIC_BODY.getModel(), stack, matrices, renderBuffer, light, overlay);
        }
        matrices.popPose();

        matrices.pushPose();
        {
            controller.applySpecialModelTransform(SpecialModels.M870_CLASSIC_BODY.getModel(), M870AnimationController.INDEX_PUMP, transformType,matrices);
            RenderUtil.renderModel(SpecialModels.M870_CLASSIC_PUMP.getModel(), stack, matrices, renderBuffer, light, overlay);
        }
        matrices.popPose();

        matrices.pushPose();
        {
            controller.applySpecialModelTransform(SpecialModels.M870_CLASSIC_BODY.getModel(), M870AnimationController.INDEX_BULLET, transformType,matrices);
            RenderUtil.renderModel(SpecialModels.M870_CLASSIC_BULLET.getModel(), stack, matrices, renderBuffer, light, overlay);
        }
        matrices.popPose();

        PlayerHandAnimation.render(controller,transformType,matrices,renderBuffer,light);
    }
}
