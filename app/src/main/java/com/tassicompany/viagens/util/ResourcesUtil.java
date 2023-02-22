package com.tassicompany.viagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.tassicompany.viagens.model.Pacote;

public class ResourcesUtil {

    public static final String DRAWABLE = "drawable";

    public static Drawable devolveDrawable(Context context, String drawableEmTxt) {
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(drawableEmTxt
                , DRAWABLE, context.getPackageName());
        return resources.getDrawable(idDoDrawable);
    }
}
