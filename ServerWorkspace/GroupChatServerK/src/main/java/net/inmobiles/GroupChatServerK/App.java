package net.inmobiles.GroupChatServerK;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		int port = 4010;
		if(args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		
		Server server = new Server(port);
		server.run();


    }
}
