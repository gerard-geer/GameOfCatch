class Ball extends Throwable{}
class Person
{
	Person target;
	String name;
	
	Person(Person target, String name)
	{
		this.target = target;
		this.name = name;
	}
	
	void aim(Ball ball)
	{
		try
		{
			System.out.println(name + " catches the ball");
			throw ball;
		}
		catch(Ball thrownBall)
		{	
			System.out.println(target.name + " catches the ball");
			target.aim(thrownBall);
		}
		catch(StackOverflowError fatigue)
		{
			System.out.println("\nTired. Going inside.");
		}
	}
	
	public static void main(String[] args)
	{
		Person parent = new Person(null, "John");
		Person child = new Person(parent, "Johnny Jr.");
		parent.target = child;
		parent.aim(new Ball());
	}	
}	