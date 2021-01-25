package Service;

import static spark.Spark.*;

public class HelloWorld 
{
	public static void main(String[] args) 
	{
        	ArrayList<Ruleta> ruletas = new ArrayList<Ruleta>(); 
		post("/Ruleta", (request, response) -> 
		{
			Ruleta ruleta = new Ruleta(ruletas.size());
			ruletas.add(ruleta); 
			return String.valueOf(ruleta.getId());
		});
		
		post("/OpenRuleta", (request, response) -> 
		{	
			try
			{
			int id = Integer.parseInt(request.body().replaceAll("[^\\d.]", ""));
			Ruleta ruleta = ruletas.get(id); 
			ruleta.setOpen(true);
			return "TRUE";
			}
			catch (Exception e)
			{
				return "FALSE";
			}
		});
	}

}
