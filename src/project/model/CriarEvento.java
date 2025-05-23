package project.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import project.endereco.Endereco;
import project.entity.Categoria;
import project.entity.Evento;
import project.utils.IntegracaoApi;

public class CriarEvento {

	public void criarEvento(Scanner s) throws Exception {

		IntegracaoApi api = new IntegracaoApi();
		Endereco end = null;

		Map<Integer, Categoria> eventos = new HashMap<>();
		eventos.put(1, Categoria.FESTAS);
		eventos.put(2, Categoria.EVENTOS_ESPORTIVOS);
		eventos.put(3, Categoria.SHOWS);
		eventos.put(4, Categoria.FEIRAS);
		eventos.put(5, Categoria.EXPOSICOES);
		eventos.put(6, Categoria.PALESTRAS);
		eventos.put(7, Categoria.TEATRO);
		eventos.put(8, Categoria.CINEMA);
		eventos.put(9, Categoria.RELIGIOSOS);
		eventos.put(10, Categoria.MANIFESTACOES);
		eventos.put(11, Categoria.WORKSHOPS);
		eventos.put(12, Categoria.INFANTIS);

		System.out.println("Escolha o Evento de acordo com seu número: ");
		System.out.println("""
				   FESTAS --------------- 1
				   EVENTOS ESPORTIVOS --- 2
				   SHOWS ---------------- 3
				   FEIRAS --------------- 4
				   EXPOSICOES ----------- 5
				   PALESTRAS ------------ 6
				   TEATRO --------------- 7
				   CINEMA --------------- 8
				   RELIGIOSOS ----------- 9
				   MANIFESTACOES -------- 10
				   WORKSHOPS ------------ 11
				   INFANTIS ------------- 12
				""");
		int evento = s.nextInt();
		s.nextLine();

		Categoria eventoEscolhido = eventos.get(evento);

		if (eventoEscolhido != null) {
			System.out.println("Evento selecionado: " + eventoEscolhido);
		} else {
			System.out.println("Evento inválido!");
		}

		System.out.println("Digite o seu Nome do Evento: ");
		String nome = s.nextLine();

		System.out.println("Digite o Cep do local do Evento: ");
		String cep = s.nextLine();

		System.out.println("Digite a Data de Inicio do Evento no formato (\"dd/MM/yyyy HH:mm\"): ");
		String inicio = s.nextLine();

		System.out.println("Digite a Data de Termino do Evento no formato (\"dd/MM/yyyy HH:mm\"): ");
		String termino = s.nextLine();

		System.out.println("Digite a descricao do Evento: ");
		String descricao = s.nextLine();

		try {
			end = api.buscaCep(cep);
			if (end == null) {
				System.out.println("CEP inválido. Tente novamente.");
			}
		} catch (Exception e) {
			System.out.println("Erro ao buscar o CEP. Verifique sua conexão.");
			return;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Evento ev = new Evento();
		ev.setNome(nome);
		ev.setEndereco(end);
		ev.setCategoria(eventoEscolhido);
		ev.setDescricao(descricao);
		ev.setHorarioInicio(LocalDateTime.parse(inicio, formatter));
		ev.setHorarioTermino(LocalDateTime.parse(termino, formatter));

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("eventos.txt", true))) {
			writer.write("Nome: " + ev.getNome());
			writer.newLine();
			writer.write("Cep: " + ev.getEndereco().getCep());
			writer.newLine();
			writer.write("Categoria: " + eventoEscolhido);
			writer.newLine();
			writer.write("Data De Inicio: " + ev.getHorarioInicio());
			writer.newLine();
			writer.write("Data de Termino: " + ev.getHorarioTermino());
			writer.newLine();
			writer.write("Descricao: " + ev.getDescricao());
			writer.newLine();
			writer.write("----------");
			writer.newLine();
			System.out.println("Evento salvo com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao salvar evento: " + e.getMessage());
		}

	}

	public void opcoes(Scanner s) throws Exception {

		System.out.println("""

				          Todos Eventos           |  Eventos que estou participando  |  Alguns Eventos ocorrendo Agora
				--------------------------------- | -------------------------------- | ---------------------------------
				                        1	             |                2                 |                3

				           		""");

		int valor = s.nextInt();
		s.nextLine();

		try (BufferedReader reader2 = new BufferedReader(new FileReader("eventos.txt"))) {
			String blocoLinha;
			boolean exibir = false;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			LocalDateTime inicio = null;
			LocalDateTime termino = null;
			StringBuilder blocoEvento = new StringBuilder();

				

			while ((blocoLinha = reader2.readLine()) != null) {
				blocoEvento.append(blocoLinha).append("\n");
				
				if (valor == 1) {
					if (blocoLinha.equals("----------")) {
						System.out.println(blocoLinha);
					} else {
						System.out.println(blocoLinha);
					}
				} else if (valor == 2) {

				} else if (valor == 3) {

					if (blocoLinha.startsWith("Data De Inicio: ")) {
						// 2025-05-12T22:17
						String inicioStr = blocoLinha.substring(16).trim();
						inicio = LocalDateTime.parse(inicioStr, formatter);
						// System.out.println("inicio data: " + inicio.getClass().getName());
						System.out.println("inicio data: " + inicio);
					}

					if (blocoLinha.startsWith("Data de Termino: ")) {
						String terminoStr = blocoLinha.substring(17).trim();
						termino = LocalDateTime.parse(terminoStr, formatter);
					}

					try {
						LocalDateTime agora = LocalDateTime.now();

						if (blocoLinha.equals("----------")) {
				            if (inicio != null && termino != null) {
				                if ((agora.isAfter(inicio) || agora.isEqual(inicio)) &&
				                    (agora.isBefore(termino) || agora.isEqual(termino))) {
				                    System.out.println("Evento ocorrendo agora!");
				                    System.out.println(blocoEvento.toString());
				                }
				            }

					
//						inicio = null;
//						termino = null;
//						eventoDentroDoPeriodo = false;

//						if (!inicio.isAfter(agora)) {
//							exibir = true;
//						} else {
//							exibir = false;
						}

					} catch (DateTimeParseException e) {
						System.out.println("Nao tem nenhum Evento ocorrendo on momento: " + inicio);
						exibir = false;

					}

					if (exibir) {
						System.out.println(blocoLinha);
					}

				}

			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}

	}
}
