package att;

// Interface esperada
// Implementação
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}

// Implementação concreta
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is turned off.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to " + volume);
    }
}

// Outra implementação concreta
class Radio implements Device {
    @Override
    public void turnOn() {
        System.out.println("Radio is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio is turned off.");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Radio volume set to " + volume);
    }
}

// Abstração
abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    abstract void turnOnDevice();
    abstract void turnOffDevice();
}

// Controle remoto específico
class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    @Override
    void turnOnDevice() {
        device.turnOn();
    }

    @Override
    void turnOffDevice() {
        device.turnOff();
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}

// Testando o Bridge
public class BridgeExample {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl remoteControl = new AdvancedRemoteControl(tv);

        remoteControl.turnOnDevice();
        ((AdvancedRemoteControl) remoteControl).setVolume(10);
        remoteControl.turnOffDevice();
    }
}
