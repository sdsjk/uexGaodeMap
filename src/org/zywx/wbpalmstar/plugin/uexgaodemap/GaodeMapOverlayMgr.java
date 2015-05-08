package org.zywx.wbpalmstar.plugin.uexgaodemap;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;

import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.TileOverlayOptions;

import org.zywx.wbpalmstar.base.cache.ImageLoadTask;
import org.zywx.wbpalmstar.base.cache.ImageLoadTask$ImageLoadTaskCallback;
import org.zywx.wbpalmstar.base.cache.ImageLoaderManager;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.ArcBean;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.CircleBean;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.GroundBean;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.PolygonBean;
import org.zywx.wbpalmstar.plugin.uexgaodemap.bean.PolylineBean;
import org.zywx.wbpalmstar.plugin.uexgaodemap.overlay.ArcOverlay;
import org.zywx.wbpalmstar.plugin.uexgaodemap.overlay.BaseOverlay;
import org.zywx.wbpalmstar.plugin.uexgaodemap.overlay.CircleOverlay;
import org.zywx.wbpalmstar.plugin.uexgaodemap.overlay.GroundNOverlay;
import org.zywx.wbpalmstar.plugin.uexgaodemap.overlay.PolygonOverlay;
import org.zywx.wbpalmstar.plugin.uexgaodemap.overlay.PolylineOverlay;
import org.zywx.wbpalmstar.plugin.uexgaodemap.util.GaodeUtils;
import org.zywx.wbpalmstar.plugin.uexgaodemap.util.OnCallBackListener;

import java.util.HashMap;
import java.util.Iterator;

public class GaodeMapOverlayMgr extends GaodeMapBaseMgr {

    private static HashMap<String, BaseOverlay> mOverlays = new HashMap<String, BaseOverlay>();
    private ImageLoaderManager manager;

    public GaodeMapOverlayMgr(Context mContext, AMap map, OnCallBackListener mListener) {
        super(mContext, map, mListener);
        manager = ImageLoaderManager.initImageLoaderManager(mContext);
    }

    public void addArc(ArcBean bean){
        if (bean == null) return;
        ArcOverlay arcOverlay = new ArcOverlay();
        ArcOptions options = bean.getData();
        if (options != null){
            Arc arc = map.addArc(options);
            if (arc != null){
                arcOverlay.setArc(arc);
                mOverlays.put(bean.getId(), arcOverlay);
            }
        }
    }

    public void addPolylines(PolylineBean bean){
        if (bean == null) return;
        PolylineOverlay polylineOverlay = new PolylineOverlay();
        PolylineOptions option = bean.getData();
        if (option != null){
            Polyline polyline = map.addPolyline(option);
            if (polyline != null){
                polylineOverlay.setPolyline(polyline);
                mOverlays.put(bean.getId(), polylineOverlay);
            }
        }
    }

    public void removeOverlay(String id){
        BaseOverlay overlay = mOverlays.get(id);
        if (overlay != null){
            overlay.clearOverlay();
        }
    }

    public void addCircle(CircleBean bean) {
        if (bean == null) return;
        CircleOverlay circleOverlay = new CircleOverlay();
        CircleOptions option = bean.getData();
        if (option != null){
            Circle circle = map.addCircle(option);
            if (circle != null){
                circleOverlay.setCircle(circle);
                mOverlays.put(bean.getId(), circleOverlay);
            }
        }
    }

    public void addPolygon(PolygonBean bean) {
        if (bean == null) return;
        PolygonOverlay polygonOverlay = new PolygonOverlay();
        PolygonOptions option = bean.getData();
        if (option != null){
            Polygon polygon = map.addPolygon(option);
            if (polygon != null){
                polygonOverlay.setPolygon(polygon);
                mOverlays.put(bean.getId(), polygonOverlay);
            }
        }
    }

    public void addGround(final GroundBean bean) {
        if (bean == null) return;
        final GroundNOverlay groundOverlay = new GroundNOverlay();
        final GroundOverlayOptions option = bean.getData();
        if (option != null && !TextUtils.isEmpty(bean.getImageUrl())){
            manager.asyncLoad(new ImageLoadTask(bean.getImageUrl()) {
                @Override
                protected Bitmap doInBackground() {
                    return GaodeUtils.getImage(mContext, filePath);
                }
            }.addCallback(new ImageLoadTask$ImageLoadTaskCallback() {
                public void onImageLoaded(ImageLoadTask task, Bitmap bitmap) {
                    if (bitmap != null) {
                        BitmapDescriptor bd = BitmapDescriptorFactory.fromBitmap(bitmap);
                        option.image(bd);
                    }
                    GroundOverlay ground = map.addGroundOverlay(option);
                    if (ground != null){
                        groundOverlay.setGroud(ground);
                        mOverlays.put(bean.getId(), groundOverlay);
                    }
                }
            }));
        }
    }

    public void clean() {
        Iterator it = mOverlays.keySet().iterator();
        while (it.hasNext()){
            final String id = it.next().toString();
            BaseOverlay overlay = mOverlays.get(id);
            if (overlay != null){
                overlay.clearOverlay();
            }
        }
    }
}
