package human;

public class C3 {

	public static void main(String[] args) {
		Human[] arrayHum = new Human[args.length];
                int humanIndex = 0;
		for (int i = 0; i < args.length; i++ )	{
			if (args[i].equals("-H"))  {
					arrayHum[humanIndex] = new Human(Integer.parseInt(args[i+2]), args[i+1]); 
					i += 3;
                                        humanIndex++;
			}
			else if (args[i].equals("-F"))	{
                                        int year;
                                        int x = Integer.parseInt(args[i+3]);
                                        if (x < 32) {
                                            year = 2000 + x;
                                        }
                                        else {
                                            year = 1900 + x;
                                        }
					arrayHum[humanIndex] = new Fysiker(Integer.parseInt(args[i+2]), args[i+1], year);
					i += 4;
                                        humanIndex++;
			}
                        else {
                            arrayHum[humanIndex] = new Human(12,"skks");
                            humanIndex++;
                        }
		}
		
            for (Human i : arrayHum) {
                System.out.println(i);
            } 

	}

}
