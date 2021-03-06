package org.tetawex.tms.ui.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

/**
 * Created by Tetawex on 08.01.2017.
 */
public class AnvilWithSword extends Widget {
    private NinePatchDrawable anvilDrawable;
    private NinePatchDrawable swordDrawable;

    public AnvilWithSword(NinePatchDrawable anvilDrawable, NinePatchDrawable swordDrawable){
        this.anvilDrawable =anvilDrawable;
        this.swordDrawable =swordDrawable;   
        setTouchable(Touchable.disabled);
    }
    @Override
    public float getPrefWidth() {
        return 320;
    }
    @Override
    public float getPrefHeight() {
        return 50;
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        //anvilDrawable.draw(batch, getX() + (getWidth() - getWidth() / 1.6f) / 2, getY(), getWidth() / 1.6f, getHeight());
        anvilDrawable.draw(batch, getX(), getY(), getPrefWidth(), getPrefHeight());
        swordDrawable.draw(batch, getX()-32, getY(), getPrefWidth()+32, getPrefHeight());
    }
    @Override
    public void act(float delta) {
        super.act(delta);

    }
}
