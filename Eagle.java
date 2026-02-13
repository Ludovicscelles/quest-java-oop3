
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
            System.out.printf("%s takes off into the air.%n", this.getName());
        }

    }

    @Override
    public void glide() {
        if (!flying) {
            System.out.printf("%s is not flying and can't glide.%n", this.getName());
        } else if (altitude <= 100) {
            System.out.printf("%s is flying but not high enough to glide.%n", this.getName());
        } else {
            System.out.printf("%s glides through the air.%n", this.getName());
        }
    }

    @Override
    public int ascend(int meters) {
        if (meters < 0) {
            System.out.println("Eagle can't ascend a negative distance.");
            return this.altitude;
        }
        if (!flying) {
            System.out.printf("%s is not flying and can't ascend.%n", this.getName());
            return this.altitude;
        }
        if (flying) {

            this.altitude += meters;
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    @Override
    public int descend(int meters) {
        if (meters < 0) {
            System.out.println("Eagle can't descend a negative distance.");
            return this.altitude;
        }
        if (!flying) {
            System.out.printf("%s is not flying and can't descend.%n", this.getName());
            return this.altitude;
        }
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
