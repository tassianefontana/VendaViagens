package com.tassicompany.viagens.util;

import androidx.annotation.NonNull;

public class DiasUtil {

    public static final String PLURAL = " dias";
    public static final String SINGULAR = " dia";

    @NonNull
    public static String formataDiasEmTxt(int dias) {
        if (dias > 1) {
            return dias + PLURAL;
        }
        return dias + SINGULAR;
    }
}
