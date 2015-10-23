package br.com.agencontratexto;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.StringGene;


public class AGEncontraTexto {

    static final String texto = "UNIPAM IA AG Jeferson";
    static final String alfabeto = "abcdefghijklmnopqrstuvxzABCDEFGHIJKLMNOPQRSTUVXZ ";
    
    public static void main(String[] args) {
        
        try {
            Genotype populacao = criarPopulacao(20);
            for(int i = 0; i<= 2000; i++){
                populacao.evolve();
            }
                
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AGEncontraTexto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   private static Genotype criarPopulacao(int tamPop) throws InvalidConfigurationException{
       
       Configuration conf = new DefaultConfiguration();
       conf.setPopulationSize(tamPop);
       conf.setPreservFittestIndividual(true);
       
       AvaliaTexto funcAvalia = new AvaliaTexto(texto);
       conf.setFitnessFunction(funcAvalia);
       
       Gene strinGene = new StringGene(conf, 1, 1, alfabeto);
       IChromosome cromossomoExemplo = new Chromosome(conf, strinGene, texto.length());
       
       conf.setSampleChromosome(cromossomoExemplo);
       
       Genotype populacao = Genotype.randomInitialGenotype(conf);
       
       return populacao;
   }
}
