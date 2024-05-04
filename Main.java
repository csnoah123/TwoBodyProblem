public class Main {
    public static void main(String[] args) {
        double[] pos1 = {150000000.0,0.0};
        double[] pos2 ={0.0,0.0};
        double[] vel1 = {1.0,1.0};
        double[] vel2 = {-1.0,-1.0};
        double m1 = 6e24;
        double m2 = 2e30;

        double dt = 0.01;
        int numIterations = 1000;
        double G = 6.67e-11;

        for(int i = 0; i < numIterations; i++){
            updatePositionsAndVelocities(pos1, pos2, vel1, vel2,m1 ,m2, dt, G);

            System.out.println("Time: " + i * dt +"s");
            System.out.println("Body 1 Position: (" + pos1[0] + ", " + pos1[1] + ")");
            System.out.println("Body 2 Position: (" + pos2[0] + ", " + pos2[1] + ")\n");

        }


    }

    public static void updatePositionsAndVelocities(double[] pos1, double[] pos2, double[] vel1, double[] vel2, double m1, double m2, double dt, double G){
        double distance = calcDistance(pos1, pos2);
        double forceMagnitude = (G*m1*m2)/(distance*distance);

        double forceX = forceMagnitude * (pos2[0] - pos1[0]) / distance;//potential problem
        double forceY = forceMagnitude * (pos2[1] - pos1[1]) / distance;


        vel1[0] += (forceX / m1) * dt;
        vel1[1] += (forceY / m1) * dt;

        vel2[0] -= (forceX / m2) * dt;
        vel2[1] -= (forceY / m2) * dt;


        pos1[0] += vel1[0] * dt;
        pos1[1] += vel1[1] * dt;

        pos2[0] += vel2[0] * dt;
        pos2[1] += vel2[1] * dt;
    }
    public static double calcDistance(double[] pos1, double[] pos2){
        double xComp1 = pos1[0];
        double yComp1 = pos1[1];
        double xComp2 = pos2[0];
        double yComp2 = pos2[1];



        double xComp = (xComp1 - xComp2);
        double yComp = (yComp1 - yComp2);

        double r = Math.sqrt(Math.pow(xComp, 2) + Math.pow(yComp, 2));

        return r;
    }



}