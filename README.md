### NOTE: LOTS OF WORK STILL ONGOING TO PERFECT THE SIMULATION

## 📘 **Photonic Dot-Product Simulator**

*A Java-based simulation framework for evaluating photonic dot-product engines using phase-encoded coherent detection.*

---

### 🧩 **Project Overview**

The **Photonic Dot-Product Simulator** models how optical computation units perform multiply–accumulate (MAC) operations using light-based modulation and detection instead of electrons.

It compares **binary** and **ternary encoding** strategies in terms of:

* **Signal-to-noise ratio (SNR)**
* **Energy per MAC (femtojoules)**
* **Empirical vs. analytic performance**
* **Active device count efficiency**

---

### ⚙️ **Core Components**

| File                               | Description                                                                                            |
| ---------------------------------- | ------------------------------------------------------------------------------------------------------ |
| `PhotonicDotProductSimulator.java` | Entry point. Loads configuration, runs comparisons, benchmarks energy sweeps, saves reports.           |
| `DeviceParams.java`                | Loads and stores photonic device parameters (responsivity, ADC specs, energy per MAC, etc.) from YAML. |
| `SimulationReport.java`            | Runs and reports results for binary vs. ternary modes, both analytically and empirically.              |
| `utils/MathUtils.java`             | Helper math functions (SNR conversions, normalization, energy efficiency ratios).                      |
| `config/device_params.yaml`        | User-editable configuration file for all physical and system-level constants.                          |
| `results/benchmark.csv`            | Auto-generated benchmark log of SNR and energy data over multiple modulator energies.                  |

---

### 🧮 **Simulation Model**

The simulator models photonic MAC operations using **phase-encoded modulation** and **coherent detection**:

#### **Equations**

1. **Photodetector Response**
   ( I = R \cdot P_{in} \cdot \cos^2(\phi) )
   where `R` = responsivity, `P_in` = input optical power, `φ` = phase shift.

2. **SNR Estimation**
   ( \text{SNR(dB)} = 10 \log_{10}\left(\frac{P_{signal}}{P_{noise}}\right) )

3. **Energy Efficiency**
   ( \text{E/MAC (fJ)} = \frac{E_{modulator} + E_{detector} + E_{ADC}}{N_{MAC}} )

---

### 📁 **Directory Structure**

```
simulator/
│
├── config/
│   └── device_params.yaml
│
├── results/
│   ├── benchmark.csv
│   └── run_YYYY-MM-DD.log
│
├── utils/
│   └── MathUtils.java
│
├── DeviceParams.java
├── SimulationReport.java
├── PhotonicDotProductSimulator.java
└── run.sh
```

---

### ⚡ **Usage**

#### **1. Compile all sources**

```bash
javac *.java utils/*.java
```

#### **2. Run the simulator**

```bash
java simulator.PhotonicDotProductSimulator
```

#### **3. View results**

* Logs are saved to `results/run_<date>.log`
* Benchmark data is saved to `results/benchmark.csv`

#### **4. Automated run**

```bash
./run.sh
```

This script:

* Compiles all files
* Runs the simulation
* Automatically timestamps and saves reports

---

### 🧪 **Benchmark Output Example**

```
=== Photonic Dot-Product (Phase-encoded Coherent Detection) ===
Modulator=MZI, Responsivity=0.9 A/W, ADC=6 bits @10.0 GSps
Vector length N=128, trials=2000

Mode     | SNR(dB)   | E/MAC (fJ)   | Analytic   | Empirical  | Active
-------------------------------------------------------------------------------
Ternary  | 33.99000  | 5800.00000   | 1.00000    | 0.00000    | 82
Binary   | 38.69000  | 4800.00000   | 1.00000    | 1.00000    | 62

Efficiency (Binary_E / Ternary_E) = 0.82759x
✅ Benchmark results saved to results/benchmark.csv
```

---

### 🧠 **Design Highlights**

| Feature               | Description                                                        |
| --------------------- | ------------------------------------------------------------------ |
| **YAML-based Config** | Human-readable device parameters; easy to modify.                  |
| **Empirical Mode**    | Can integrate real experimental data for noise, phase jitter, etc. |
| **Modular Design**    | Each module (device, report, simulator) can be reused or extended. |
| **Benchmark Sweep**   | Tests multiple modulator energies for trade-off studies.           |
| **Extensible**        | Prepared for hardware integration with FPGA/optical testbeds.      |

---

### 🔬 **Future Work (Hardware Path)**

| Stage                             | Goal                                                                   |
| --------------------------------- | ---------------------------------------------------------------------- |
| **1. Hardware Abstraction Layer** | Map `DeviceParams` to real photonic device driver APIs.                |
| **2. FPGA Integration**           | Replace simulated data paths with measured data from ADC/DAC.          |
| **3. Photonic Chip Interface**    | Control modulator bias voltages, laser sources, and detector readouts. |
| **4. Calibration Routine**        | Auto-calibrate phase encoding using in-situ photodiodes.               |
| **5. Mixed-Signal Co-Simulation** | Combine SPICE-level electrical models with optical response models.    |

---

### 📄 **Generated Files**

| File                 | Description                                          |
| -------------------- | ---------------------------------------------------- |
| `run_<date>.log`     | Plain-text simulation log with all results.          |
| `benchmark.csv`      | Numeric data for energy sweeps (ready for plotting). |
| `device_params.yaml` | Configuration file for hardware/optical setup.       |

---

### 🧱 **Build Script (`run.sh`)**

```bash
#!/bin/bash
echo "🚀 Building Photonic Dot-Product Simulator..."

javac *.java utils/*.java
if [ $? -ne 0 ]; then
  echo "❌ Build failed."
  exit 1
fi

echo "✅ Build successful. Running simulation..."
java simulator.PhotonicDotProductSimulator

echo "📁 Results saved in ./results/"
```

---

### 👨‍🔬 **Author**

**Jesse Oyofo Dan-Amuda**
Chief Technology Officer, **DigitWhale Innovations LTD**
Email: [contact@digitwhale.com](mailto:contact@digitwhale.com)
Expertise: Photonic Computing, AI Infrastructure, Java & Systems Engineering

---
