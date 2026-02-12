
public class Eagle extends Bird implements Fly {

    private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
        }
        System.out.printf("%s takes off into the sky.%n", this.getName());
    }

    @Override
    public void glide() {
        if (flying && altitude > 0) {
            System.out.println("glides into the air.");
        } else if (!flying) {
            System.out.printf("%s is not flying and cannot glide.%n", getName());
        } else {
            System.out.printf("%s is flying but at ground level and cannot glide.%n", getName());
        }

    }

    @Override
    public int ascend(int meters) {
        if (flying) {
            this.altitude += meters;
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (flying) {
            this.altitude = Math.max(this.altitude - meters, 0);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public void land() {
        if (!flying) {
            System.out.printf("%s is already on the ground.%n", this.getName());
            return;
        }
        if (altitude >= 10) {
            System.out.printf("%s is too high, it can't land.%n", this.getName());
            return;
        }

        System.out.printf("%s lands on the ground.%n", this.getName());
        this.flying = false;
        this.altitude = 0;
    }

}
