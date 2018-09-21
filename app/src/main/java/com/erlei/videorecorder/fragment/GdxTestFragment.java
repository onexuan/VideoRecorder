package com.erlei.videorecorder.fragment;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erlei.gdx.files.AndroidFiles;
import com.erlei.gdx.graphics.Texture;
import com.erlei.gdx.graphics.g2d.BitmapFont;
import com.erlei.gdx.graphics.g2d.SpriteBatch;
import com.erlei.videorecorder.R;
import com.erlei.videorecorder.camera.Size;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by lll on 2018/9/14
 * Email : lllemail@foxmail.com
 * Describe : 测试GDX
 */
public class GdxTestFragment extends Fragment implements GLSurfaceView.Renderer {


    public static GdxTestFragment newInstance() {
        return new GdxTestFragment();
    }

    private GLSurfaceView mSurfaceView;
    private SpriteBatch mBatch;
    private Texture mTexture;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gdx_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        mSurfaceView = view.findViewById(R.id.SurfaceView);
        mSurfaceView.setEGLContextClientVersion(3);
        mSurfaceView.setRenderer(this);
        mSurfaceView.setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }


    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        mBatch = new SpriteBatch(new Size(mSurfaceView.getWidth(), mSurfaceView.getHeight()));
        mTexture = new Texture(AndroidFiles.getInstance().absolute("/sdcard/DCIM/test1.jpg"));
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        mBatch.begin();
        mBatch.draw(mTexture, 0 , 0,mSurfaceView.getWidth(),mSurfaceView.getHeight());
        mBatch.end();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mTexture.dispose();
        mBatch.dispose();
    }

}