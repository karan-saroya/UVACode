#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int *tree;
int length;
int create_seg_tree(int parent)
{
	if(2*parent > length)
		return tree[parent];
	else
	{
		
		int min_a=create_seg_tree(2*parent);
		int min_b=create_seg_tree(2*parent+1);
		tree[parent]=min_a<=min_b? min_a:min_b;
		return tree[parent];
	}
	
	
}
void inorder(int root)
{

	if(root > length )
		return;
	else
	{
		inorder(2*root);
		printf("%d\t",tree[root]);
		inorder(2*root+1);
	}
	
}
int main()
{
	int num_el;
	printf(" Enter the number of elements\n");
	scanf("%d",&num_el);
	int rest= pow(2,ceil(log2(num_el)))-1;
	tree= (int *)malloc(sizeof(int)*(num_el + rest+1));
	for(int i=rest+1;i<=rest+num_el;i++)
	{
		scanf("%d",tree+i);
	}

	
	length=rest+num_el;
	create_seg_tree(1);
	inorder(1);
}
