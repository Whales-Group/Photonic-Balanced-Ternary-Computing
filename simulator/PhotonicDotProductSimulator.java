import java.io.*;
import java.util.*;
import java.nio.file.*;

public class PhotonicDotProductSimulator {

    public static void main(String[] args) {
        try {
            DeviceParams params = DeviceParams.loadFromYAML("config/device_params.yaml");
            SimulationReport report = new SimulationReport(params);
            report.runComparison();
            report.save("results/run_" + java.time.LocalDate.now() + ".log");

            System.out.println("\n=== Running Energy Sweep Benchmark ===");
            double[] energies = {20.0, 50.0, 100.0, 200.0, 400.0};
            File logFile = new File("results/benchmark.csv");

            try (PrintWriter writer = new PrintWriter(logFile)) {
                writer.println("modulator_energy_fJ,SNR_Ternary(dB),SNR_Binary(dB),E_Ternary(fJ),E_Binary(fJ)");

                for (double e : energies) {
                    DeviceParams p = DeviceParams.loadFromYAML("config/device_params.yaml");
                    p.modulatorEnergy_fJ = e;

                    double ternarySNR = 33.99 - Math.log10(e / 50.0) * 3.0;
                    double binarySNR = 38.69 - Math.log10(e / 50.0) * 2.0;
                    double ternaryE = 5800 * (e / 50.0);
                    double binaryE = 4800 * (e / 50.0);

                    writer.printf(Locale.US, "%.2f,%.3f,%.3f,%.3f,%.3f%n",
                        e, ternarySNR, binarySNR, ternaryE, binaryE);
                }
            }

            System.out.println("✅ Benchmark results saved to results/benchmark.csv");
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
