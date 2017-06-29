package quickunion;

import java.util.*;
import java.io.*;
import java.lang.*;


/* Name of the class has to be "Main" only if the class is public. */
class quickunion
{
	public int[] id;
	public int[] size;
	
	public quickunion(int N)
	{
		id = new int[N];
		size = new int[N];
		for(int i=0;i<N;i++)
		{
			id[i] = i;
			size[i] = 1;
		}
	}
	
	private int root(int a)
	{
		while(id[a]!=a)
			{
			id[a]=id[id[a]];
			a=id[a];
			}
		return a;
	}
	
	boolean connected(int p, int q)
	{
		return (root(p) == root(q));
	}
	
	public void union(int p, int q)
	{
	    int	pr = root(p);
		int qr = root(q);
		if(size[pr]<=size[qr])
		{
			id[pr] = qr;
			size[qr] += size[pr];
		}
		else
		{
			id[qr] = pr;
			size[pr] += size[qr];
		}
	}
	
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of nodes!");
		int N = scan.nextInt();
	    quickunion ob = new quickunion(N);
	    int cont;
	    do
	    {
	    	int a, b;
	    	int choice;
	        System.out.println("Enter the two numbers");
	    	a = scan.nextInt();
	    	b = scan.nextInt();
	    	System.out.println("Enter choice 1- union, 2- connected : ");
	    	choice = scan.nextInt();
	    	if(choice==1)
	    	{
	    	ob.union(a,b);
	    	}
	    	else
	    	{
	    	if(ob.connected(a,b))
	    		System.out.printf("%d and %d are connected!\n", a, b);
	    	else
	    		System.out.printf("%d and %d are NOT connected!\n", a, b);
	    	}
	    	System.out.println("Press 1 to continue;");
	    	cont = scan.nextInt();
	    }
	    while(cont==1);
	    
	scan.close();
	}
}

