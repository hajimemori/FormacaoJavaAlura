package testeFileFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ListaDentroPasta {
	public static void main(String[] args) throws IOException {
		String arquivos[];
		List<File> filesInFolder = Files.walk(Paths.get("B:\\OneDrive\\Documentos\\Estudos\\HTML e CSS\\Exercicios"))
		     .filter(Files::isRegularFile)
		     .map(Path::toFile)
		     .collect(Collectors.toList());
		System.out.println(filesInFolder);
	}

}
