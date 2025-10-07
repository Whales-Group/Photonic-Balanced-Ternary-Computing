import java.io.*;
import java.util.*;

public class MathUtils {
    public static double db(double linear) {
        return 10.0 * Math.log10(linear);
    }

    public static double linear(double db) {
        return Math.pow(10.0, db / 10.0);
    }

    // Convert ternary value (-1,0,1) to optical field amplitude
    public static double tritToField(int trit, DeviceParams p) {
        return trit * p.channelAmplitude_Au;
    }

    // Compute optical power given field sum (simplified: |E|^2)
    public static double computeOpticalPower_W(double fieldSum, DeviceParams p, int numChannels) {
        return (fieldSum * fieldSum) / numChannels;
    }

    // Convert optical power to detector current (I = R * P)
    public static double opticalPowerToCurrent(double power_W, DeviceParams p) {
        return power_W * p.detectorResponsivity;
    }
}
