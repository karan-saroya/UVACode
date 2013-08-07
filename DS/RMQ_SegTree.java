import java.io.*;
public class RMQ_SegTree
{
	static int[] tree;
	public static void main(String[] args) throws Exception
	{
		int num_el;
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		num_el=Integer.parseInt(buf.readLine());
		int rest =(int)Math.round(Math.pow(2, Math.ceil(Math.log(num_el)/Math.log(2))))-1;
		tree = new int[rest+num_el+1];
		for(int i=rest+1;i<=rest+num_el;i++)
			tree[i]=Integer.parseInt(buf.readLine());
		create_seg_tree(1);
		inorder(1);


	}
	static int create_seg_tree(int parent)
	{
		if(parent*2 < tree.length && parent*2+1 <tree.length)
		{
			int min_a = create_seg_tree(2*parent);
			int min_b = create_seg_tree(2*parent+1);
			tree[parent] = Math.min(min_a, min_b);
			return tree[parent];
		}
		else
			return tree[parent];

	}
	static int inorder(int root)
	{
		if(root < tree.length)
		{
			inorder(2*root);
			System.out.print(tree[root]+"\t");
			inorder(2*root+1);
			return 1;
		}
		else
			return 0;

	}

}