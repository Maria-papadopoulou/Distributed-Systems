/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "ask1.h"

//α ερώτημα
/*
* Το εσωτερικό γινόμενο των δύο διανυσμάτων Χ ∙ Υ (επιστροφή: ένας ακέραιος αριθμός)
*/
void vector_ask1_2(char *host)
{
	CLIENT *clnt;
	int  *result_1, i;
	data1  innerproduct_2_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, VECTOR_ASK1, INNERPRODUCT_VERSION, "udp");
	if (clnt == NULL) 
	{
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
/*Ζητάμε το μέγεθος του πίνακα*/
	printf("Δώσε το Ν:");
	scanf("%d", &innerproduct_2_arg.n);
	innerproduct_2_arg.X.X_len=innerproduct_2_arg.n; //αρχικοποιηση μεγεθους πινακα Ν
	innerproduct_2_arg.X.X_val=(int *)malloc(innerproduct_2_arg.n*sizeof(int)); //δεσμευση μνημης διανυσματος Χ
	innerproduct_2_arg.Y.Y_len=innerproduct_2_arg.n; //αρχικοποιηση μεγεθους πινακα Ν
	innerproduct_2_arg.Y.Y_val=(int *)malloc(innerproduct_2_arg.n*sizeof(int)); //δεσμευση μνημης διανυσματος Υ

	/*Γεμισμα διανυσματων Χ,Υ με τιμες*/
	for(i=0;i<innerproduct_2_arg.n;i++)
	{
		printf("%dος αριθμός του διανύσματος Χ:", i+1);
		scanf("%d", &innerproduct_2_arg.X.X_val[i]);
		printf("%dος αριθμός του διανύσματος Y:", i+1);
		scanf("%d", &innerproduct_2_arg.Y.Y_val[i]);
	}
	result_1 = innerproduct_2(&innerproduct_2_arg, clnt);
	if (result_1 == (int *) NULL) 
	{
		clnt_perror (clnt, "call failed");
	}
	else
	{
		printf("Εσωτερικό γινόμενο X*Y = %d\n", *result_1); //ερμφανιση αποτελεσματος
	}
	printf("*****************************************\n\n");
#ifndef	DEBUG
	clnt_destroy (clnt); //free
#endif	 /* DEBUG */
}

//β ερωτημα
/*
*  Τη μέση τιμή κάθε διανύσματος: ΕΧ, ΕΥ (επιστροφή: ένας πίνακας 2 πραγματικών αριθμών)
*/
void vector_ask1_3(char *host)
{
	CLIENT *clnt;
	out2  *result_1;
	data2  avgexey_3_arg;
	int i;

#ifndef	DEBUG
	clnt = clnt_create (host, VECTOR_ASK1, AVGEXEY_VERSION, "udp");
	if (clnt == NULL) 
	{
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

/*Ζητάμε το μέγεθος του πίνακα*/
	printf("Δώσε το Ν:");
	scanf("%d", &avgexey_3_arg.n);
	avgexey_3_arg.X.X_len=avgexey_3_arg.n; //αρχικοποιηση μεγεθους πινακα με Ν στοιχεια
	avgexey_3_arg.X.X_val=(int *)malloc(avgexey_3_arg.n*sizeof(int)); //δεσμευση μνημης του διανυσματος Χ
	avgexey_3_arg.Y.Y_len=avgexey_3_arg.n; //αρχικοποιηση μεγεθους πινακα με Ν στοιχεια
	avgexey_3_arg.Y.Y_val=(int *)malloc(avgexey_3_arg.n*sizeof(int)); //δεσμευση μνημης του διανυσματος Υ

	/*Γεμισμα διανυσματων Χ,Υ με τιμες*/
	for(i=0;i<avgexey_3_arg.n;i++)
	{
		printf("%dος αριθμός του διανύσματος Χ:", i+1);
		scanf("%d", &avgexey_3_arg.X.X_val[i]);
		printf("%dος αριθμός του διανύσματος Y:", i+1);
		scanf("%d", &avgexey_3_arg.Y.Y_val[i]);
	}
	result_1 = avgexey_3(&avgexey_3_arg, clnt);
	if (result_1 == (out2 *) NULL) 
	{
		clnt_perror (clnt, "call failed");
	}
	else
	{
		printf("Μέση τιμή Χ= %lf\n", result_1->A.A_val[0]); //ερμφανιση μεσης τιμης Χ
		printf("Μέση τιμή Y= %lf\n", result_1->A.A_val[1]); //ερμφανιση μεσης τιμης Υ
	}
	printf("*****************************************\n\n");
#ifndef	DEBUG
	clnt_destroy (clnt); //free
#endif	 /* DEBUG */
}

//γ ερώτημα
/*
* Το γινόμενο r*(Χ+Y) (επιστροφή: ένα διάνυσμα-πίνακας πραγματικών αριθμών μήκους n)
*/
void vector_ask1_4(char *host)
{
	CLIENT *clnt;
	out3  *result_1;
	data3  gin_4_arg;
	int i;
	

#ifndef	DEBUG
	clnt = clnt_create (host, VECTOR_ASK1, GIN_VERSION, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */

//Ζηταμε το μεγεθος του διανυσματος
	 printf("Δώσε το Ν:");
	 scanf("%d", &gin_4_arg.n);

//Ζηταμε τον πραγματικο αριθμο r
	 printf("Δώσε το r:");
	 scanf("%lf", &gin_4_arg.r);
	gin_4_arg.X.X_len=gin_4_arg.n; //αρχικοποιηση μεγεθους πινακα Ν
	gin_4_arg.X.X_val=(int *)malloc(gin_4_arg.n*sizeof(int)); //δεσμευση μνημης για το διανυσμα Χ
	gin_4_arg.Y.Y_len=gin_4_arg.n; //αρχικοποιηση μεγεθους πινακα με Ν στοιχεια
	gin_4_arg.Y.Y_val=(int *)malloc(gin_4_arg.n*sizeof(int)); //δεσμευση μνημης για το διανυσμα Υ

	//Γεμίζουμε τα διανυσματα με τιμες
	for(i=0;i<gin_4_arg.n;i++)
	{
		printf("%dος αριθμός του διανύσματος Χ:", i+1);
		scanf("%d", &gin_4_arg.X.X_val[i]);
		printf("%dος αριθμός του διανύσματος Y:", i+1);
		scanf("%d", &gin_4_arg.Y.Y_val[i]);
	}
	result_1 = gin_4(&gin_4_arg, clnt);
	if (result_1 == (out3 *) NULL) 
	{
		clnt_perror (clnt, "call failed");
	}
	else
	{

		//Εμφανιση αποτελεσματος
		for(i=0;i<gin_4_arg.n;i++)
		{
			
			printf("%lf *  (%d + %d )=  %lf\n",gin_4_arg.r, gin_4_arg.X.X_val[i],gin_4_arg.Y.Y_val[i], result_1->B.B_val[i]);
			
		}
		printf("*****************************************\n\n");
	}
#ifndef	DEBUG
	clnt_destroy (clnt); //free
#endif	 /* DEBUG */
}

int main (int argc, char *argv[])
{
	char *host;
	int choice=0;
	char c;

	if (argc < 2) //ελεγχουμε αν ο χρηστης εχει δωσει το localhost
	{
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	//Μενου επιλογων
		while(choice!=4)
		{
			do
			{
					printf("Μενού Επιλογών\n");
					printf("1.Εσωτερικό γινόμενο δύο διανυσμάτων Χ,Υ\n2.Μέση τιμή διανυσμάτων\n3.Γινόμενο r*(x+y)\n4.Έξοδος\n");
					printf("Εισαγωγή Επιλογής: ");
					scanf("%d", &choice);
				printf("*****************************************\n\n");	
			} while((choice<=0) || (choice>=5));
			switch(choice)
			{
					case 1:
						vector_ask1_2 (host); 
						break; //καλουμε τη συναρτηση για το α ερωτημα
					case 2:
						vector_ask1_3 (host); 
						break;//καλουμε τη συναρτηση για το β ερωτημα
					case 3:
						vector_ask1_4 (host); 
						break; //καλουμε τη συναρτηση για το γ ερωτημα
					default:
						printf("Έξοδος!\n"); 
						break;
			}
			

		}               		 
exit (0);
}
