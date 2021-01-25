package Service;

import static spark.Spark.*;

public class HelloWorld 
{
	public static void main(String[] args) {
        post("/rule", (request, response) -> "Hello Worlddd");
    }

}
