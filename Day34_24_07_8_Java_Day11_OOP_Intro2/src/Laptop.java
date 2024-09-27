package src;

public class Laptop {

// String hersteller;
// float cpuHz; // 3.2f ==> 3.2 GHz
// int ram;  // zb 16 => 16GB
// int diskSpace; // 512 => 512 GB
// float monitorSize; // 15.6 ==> 15.6"
// float weight; // 1.48 ==> 1.48 kg

// Aufgabe:
// implementiere die Laptop klasse mit einem konstruktor der alle werde akzeptiert
// implementiere getter und setter (attr sind private)
//      baue checks ein beim setten (selber überlegen)
//      hersteller nur "Apple", "Samsung", "Toshiba", "Acer", "HP", "Dell"
// implementiere eine toString methode
// implementiere eine printInfo methode


String hersteller = "Custom";
float cpuHz;
int ram;
int diskSpace;
float monitorSize; 
float weight;

public Laptop() {
}

public Laptop(String hersteller, float cpuHz, int ram, int diskSpace, float monitorSize, float weight) {
    setHersteller(hersteller);
    this.cpuHz = cpuHz;
    this.ram = ram;
    this.diskSpace = diskSpace;
    this.monitorSize = monitorSize;
    this.weight = weight; 
}

public String getHersteller() {
    return hersteller;
}

public void setHersteller(String hersteller) {
    if (hersteller == "Apple" || hersteller == "Samsung" || hersteller == "Toshiba" || hersteller ==  "Acer" || hersteller == "HP" || hersteller == "Dell" )
    this.hersteller = hersteller;
}

public float getCpuHz() {
    return cpuHz;
}

public void setCpuHz(float cpuHz) {
    this.cpuHz = cpuHz;
}

public int getRam() {
    return ram;
}

public void setRam(byte ram) {
    this.ram = ram;
}

public int getDiskSpace() {
    return diskSpace;
}

public void setDiskSpace(int diskSpace) {
    this.diskSpace = diskSpace;
}

public float getMonitorSize() {
    return monitorSize;
}

public void setMonitorSize(float monitorSize) {
    this.monitorSize = monitorSize;
}

public float getWeight() {
    return weight;
}

public void setWeight(float weight) {
    this.weight = weight;
}

@Override
public String toString() {
    return this.hersteller + " " + this.cpuHz + " GHz " + this.ram + " GB " + this.diskSpace + " GB " + monitorSize + "\" " + weight + " kg";
}

public void printInfo() {
   System.out.println(toString());
}

}

