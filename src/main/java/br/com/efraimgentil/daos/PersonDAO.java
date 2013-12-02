package br.com.efraimgentil.daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Repository;

import br.com.efraimgentil.models.Person;

@Repository
public class PersonDAO {
	
	
	public void persistAll(Person[] persons , File file) throws Exception{
		
		if(persons == null || persons.length == 0){
			throw new IllegalArgumentException("List of persons null or empty");
		}
		
		if(file == null){
			throw new IllegalArgumentException("File is null");
		}
		try( ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(file) ) ) {
			oos.writeObject( persons );
		}
	}
	
	public Person[] readFile(File file) throws IOException{
		Person[] persons = null;
		try ( ObjectInputStream ois = new ObjectInputStream( new FileInputStream(file) ) ) {
			persons = (Person[]) ois.readObject();
		}catch(ClassNotFoundException ex){
			throw new IOException("Erro on reading file. ClassNotFound" , ex );
		}
		return persons;
		
	}
	
	
}
