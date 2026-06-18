class Computer {
    private String CPU, RAM, storage;
    private Computer(Builder builder) {
        this.CPU = builder.CPU; this.RAM = builder.RAM; this.storage = builder.storage;
    }
    public static class Builder {
        public String CPU, RAM, storage;
        public Builder setCPU(String cpu) { this.CPU = cpu; return this; }
        public Builder setRAM(String ram) { this.RAM = ram; return this; }
        public Builder setStorage(String storage) { this.storage = storage; return this; }
        public Computer build() { return new Computer(this); }
    }
    public String toString() { return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + "]"; }
}
public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer comp = new Computer.Builder().setCPU("Intel i7").setRAM("16GB").setStorage("512GB SSD").build();
        System.out.println(comp);
    }
}

/*
Output:
Computer [CPU=Intel i7, RAM=16GB, Storage=512GB SSD]
*/
