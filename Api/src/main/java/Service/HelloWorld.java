package Service;

import static spark.Spark.*;

public class HelloWorld 
{
	public static void main(String[] args) 
	{
        	ArrayList<Ruleta> ruletas = new ArrayList<Ruleta>(); 
		
		get("/Ruletas", (request, response) -> 
		{ 
			String resp = "";
			for (Ruleta ruleta : ruletas) 
			{
				resp += "Ruleta: " + ruleta.getId();
				resp += " Estado: " + (ruleta.getOpen() ? "ABIERTA" : "CERRADA");
				resp += " || ";
			}  
			return resp;
		});
		
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
		
		post("/Apuesta", (request, response) -> 
        	{
			try
			{
				String[] arrParams = request.body().split(",");
				String[] temp = new String[2];
				Map<String,String> params = new HashMap<String,String>(); 
				for (String string : arrParams) 
				{
					temp = string.split(":");
					params.put(temp[0].replaceAll("\\W+",""), temp[1].replaceAll("\\W+",""));
				}      		
				int id = Integer.parseInt(params.get("id"));
				Ruleta ruleta = ruletas.get(id);
				boolean victory = ruleta.apuesta(params.get("bet"));
				return "TRUE: " + ((victory) ? "VICTORY" : "DEFEAT");
			}
			catch (Exception e)
			{
				return "FALSE";
			}
		});
	}

}
