/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campeonatos;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Wesley
 */
public class Jogos {
    private int codigo;
    private String data;
    private String timeA;
    private String timeB;
    private double renda;
    private int publico;
    private Estadios estadios;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimeA() {
        return timeA;
    }

    public void setTimeA(String timeA) {
        this.timeA = timeA;
    }

    public String getTimeB() {
        return timeB;
    }

    public void setTimeB(String timeB) {
        this.timeB = timeB;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public int getPublico() {
        return publico;
    }

    public void setPublico(int publico) {
        
            this.publico=publico;
        
    }

    public Estadios getEstadios() {
        return estadios;
    }

    public void setEstadios(Estadios estadios) {
        this.estadios = estadios;
    }
    
    public static void serializar(ArrayList<Jogos> lista) throws IOException{
        XStream x = new XStream(new DomDriver());
        String arquivoXML = x.toXML(lista);
        File file = new File("Jogos.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(arquivoXML);
        bw.close();
    }
    
    public static ArrayList<Jogos> deserealiza() throws FileNotFoundException, IOException{
        FileReader ler = new FileReader("Jogos.txt");
        BufferedReader reader = new BufferedReader(ler);
        String linha = "";
        String arquivo = "";
        while ((linha = reader.readLine())!= null){
            arquivo += linha + "\n";
        }
        ArrayList<Jogos> lista = new ArrayList<>();
        XStream x  = new XStream(new DomDriver());
        lista = (ArrayList<Jogos>) x.fromXML(arquivo);
        return lista;
    }
}
