// criei a classe para poder dar os atributos
public class Universidade {
	//atributo privado da classe
	    private String nome;
	    private String ra;           // recebe o RA do aluno
	    private double[] notas;      // array para receber as notas
	    private boolean notaEAD;         // para receber as notas do EAD
	    private double pres;     // Percentual de presença para disciplinas presenciais

	    // metodo construtor para receber as caracteristicas EAD
	    public Universidade(String nome, String ra, double[] notas) {
	    	// para dar os valores aos atributos das materias EAD
	        this.nome = nome;        
	        this.ra = ra;          
	        this.notas = notas;      
	        this.notaEAD = true;         
	    }

	    // metodo construtor para receber as caracteristicas das materias presenciais
	    public Universidade(String nome, String ra, double[] notas, double pres) {
	    	// para dar os valores aos atributos para as materias presenciais
	        this(nome, ra, notas);
	        this.notaEAD = false;
	        this.pres = pres;
	    }

	    // criei o metodo para fazer o calculo da NF
	    public double calNF() {
	    	// variavel para iniciar a conta da NF
	        double NF = 0;                
	        int totalAvaliacoes = notas.length;  // recebe o numero de avaliações

	        // ve a quantia de avaliações
	        if (totalAvaliacoes == 1 || totalAvaliacoes == 2) {
	            // caso a quantidade de notas seja até 2 vai usar media aritmética
	            for (double nota : notas) {
	                NF += nota;             // faz a soma de todas as notas
	            }
	            return NF / totalAvaliacoes; // devolve a média das notas
	        } else if (totalAvaliacoes == 3) {
	            // caso seja até 3 notas vai usar média ponderada
	            return (notas[0] + 2 * notas[1] + 2 * notas[2]) / 5; // conta da media ponderada
	        } else if (totalAvaliacoes == 4) {
	            // caso seja até 4 notas vai usar cálculo com pesos definidos
	            return (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45); // Cálculo com os pesos definidos
	        }

	        return -1; // caso tenha algo errado vai informar o -1
	    }

	    // metodo que faz a verificação caso o aluno tenha a nota aprovada
	    public String situacao() {
	        double notafinal = calNF(); // faz a conta da NF
	        // faz a verificação de qual das notas (EAD ou presencial)
	        if (notaEAD) {
	            return notafinal >= 5 ? "Aprovado" : "Reprovado"; // se tiver nota maior ou igual a 5 = aprovado
	        } else {
	            return (notafinal >= 5 && pres >= 75) ? "Aprovado" : "Reprovado"; // caso a nota seja maior ou igual a 5 e tiver mais que 75% de presença
	        }
	    }

	    // metodo para informar o resultado final do aluno
	    public void resultado() {
	        double notafinal = calNF(); // faz a conta da NF
	        String situacao = situacao();   // ve a situação do aluno (se esta aprovado ou não

	        // Imprime as informações do aluno formatadas
	        System.out.printf("Nome do aluno: %s\nRA do aluno: %s\nNota Final: %.2f\nSituação do aluno: %s\n", nome, ra, notafinal, situacao);
	    }
	    
	    public static void main(String[] args) {
	        double[] NP = {7.0, 9, 5.0, 5.0};  // novo objeto para atribuir o valor das 4 notas
	        Universidade a1 = new Universidade("Luiz Eduardo Vieira de Paula", "248304", NP, 95);
	        a1.resultado();

	        System.out.println(" ");
	        
	        double[] notasEAD = {5.0, 6.0, 7.0};  // novo objeto para atribuir as 3 notas
	        Universidade a2 = new Universidade("Wellington Rato", "243784", notasEAD);
	        a2.resultado();

	        System.out.println(" ");
	        
	        double[] n2 = {8.0, 9.0};  // novo objeto para atribuir as 2 notas
	        Universidade a3 = new Universidade("Jandrei", "248765", n2, 65);
	        a3.resultado();
	    }
	}