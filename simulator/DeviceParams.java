import java.io.*;
import java.util.*;


public class DeviceParams {
    // Laser
    public double laserPower_mW;
    public double localOscillatorPower_mW;

    // Modulator
    public String modulatorType;
    public double modulatorEnergy_fJ;

    // Detector
    public double detectorResponsivity;

    // ADC
    public int adcBits;
    public double adcSampleRate_GSps;
    public double adcEnergy_fJ_per_sample;

    // Optical channel
    public double opticalLoss_dB;

    // Simulation
    public int vectorLength;
    public int monteCarloTrials;

    // Derived / additional
    public double channelAmplitude_Au = 1.0; // placeholder for amplitude units


    public static DeviceParams loadFromYAML(String path) throws IOException {
        DeviceParams p = new DeviceParams();
        List<String> lines = java.nio.file.Files.readAllLines(java.nio.file.Paths.get(path));
        for (String line : lines) {
            if (!line.contains(":")) continue;
            String[] kv = line.split(":");
            String key = kv[0].trim();
            String val = kv[1].trim();
            switch (key) {
                case "modulator_type": p.modulatorType = val.replace("\"", ""); break;
                case "laser_power_mw": p.laserPower_mW = Double.parseDouble(val); break;
                case "modulator_energy_fj": p.modulatorEnergy_fJ = Double.parseDouble(val); break;
                case "detector_responsivity": p.detectorResponsivity = Double.parseDouble(val); break;
                case "adc_bits": p.adcBits = Integer.parseInt(val); break;
                case "adc_sample_rate_gsps": p.adcSampleRate_GSps = Double.parseDouble(val); break;
                case "adc_energy_fj_per_sample": p.adcEnergy_fJ_per_sample = Double.parseDouble(val); break;
                case "optical_loss_db": p.opticalLoss_dB = Double.parseDouble(val); break;
                case "vector_length": p.vectorLength = Integer.parseInt(val); break;
                case "monte_carlo_trials": p.monteCarloTrials = Integer.parseInt(val); break;
                case "local_oscillator_power_mw": p.localOscillatorPower_mW = Double.parseDouble(val); break;
            }
        }
        return p;
    }
}
