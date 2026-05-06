package com.example.artikelfinder;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.transform.Scale;
import javafx.util.Duration;

import static javafx.scene.transform.Transform.scale;

public class AnimationManager {

    // اداة تطبيق التلاشي و الانبثاق
    public static void fade(Node node, double time, double startValue, double endValue) {

        FadeTransition fade = new FadeTransition(Duration.seconds(time), node);
        node.setOpacity(startValue);
        fade.setFromValue(startValue);
        fade.setToValue(endValue);
        fade.play();
    }

    // ❌ Shake
    public static void shake(Node node, double durationMill, double fromValue, double toValue, int cycle, boolean autoRev) {
        TranslateTransition shake = new TranslateTransition(Duration.millis(50), node);
        shake.setFromX(fromValue);
        shake.setToX(toValue);
        shake.setCycleCount(cycle);
        shake.setAutoReverse(autoRev);
        shake.play();
    }
    // 🔘 Hover على الزر
    public static void nodeHover(Node node) {
        node.setOnMouseEntered(e -> scale(node, 1.1));
        node.setOnMouseExited(e -> scale(node, 1));
    }

    public static void scale(Node node, double value) {
        ScaleTransition st = new ScaleTransition(Duration.millis(150), node);
        st.setToX(value);
        st.setToY(value);
        st.play();
    }




}
