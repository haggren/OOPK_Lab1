package human;

public class C3 {

	public static void main(String[] args) {
		Human[] arrayHum = new Human[args.length];
		for (int i = 0; i < args.length; i++ )	{
			if (args[i] == "-H")  {
					arrayHum[i] = new Human(Integer.parseInt(args[i+2]), args[i+1]); 
					i += 2;		
			}
			else if (args[i] == "-F")	{
					arrayHum[i] = new Fysiker(Integer.parseInt(args[i+2]), args[i+1], Integer.parseInt(args[i+3]));
					i += 3;
			}
			else {
				throw new IllegalArgumentException("Felaktigt format på indata!");
			}
		}
		
		System.out.println(arrayHum[1].toString());

	}

}
