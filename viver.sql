CREATE DATABASE  IF NOT EXISTS `viversaudavel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `viversaudavel`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: viversaudavel
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alimento` (
  `id_alimento` bigint(20) NOT NULL AUTO_INCREMENT,
  `calorias` int(11) NOT NULL,
  `desc_alimento` longtext,
  `nm_alimento` varchar(50) NOT NULL,
  `periodo_dia` varchar(20) NOT NULL,
  `porcao` varchar(20) DEFAULT NULL,
  `regiao_tipica` varchar(20) NOT NULL,
  `url_imagem_alimento` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_alimento`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (1,150,'Prato muito pedido no Nordeste, é uma boa opção para o jantar. ','Macaxeira com queijo','Noite','100','Nordeste','http://4.bp.blogspot.com/_vrKie2tAwFU/SreVAiZEeBI/AAAAAAAACmg/z6N5Ws_KdEA/s320/PA170047.JPG'),(2,100,'O Baião de Dois surgiu no Ceará, quando o povo nordestino passava por problemas devido a seca na região, a comida era escassa e era preciso guardar o necessário, sem que houvesse desperdício','Baião de dois','Tarde','100','Nordeste','http://4.bp.blogspot.com/-DROruXi5RgM/UfK3ww-SDmI/AAAAAAAAD68/uXb-AXmOgXc/s1600/arrozbaiaodedois.jpg'),(3,185,'Tipo de massa alimentícia com o formato de tubos curtos, em que se incluem os penne, ravioli e os cotovelos. No Brasil, a introdução da massa em nossos hábitos alimentares coube aos imigrantes italianos, principalmente na região Sul','Macarronada','Tarde','100','Nordeste','http://receitasde.blog.br/wp-content/uploads/2015/06/receita-de-macarronada.jpg'),(4,100,'Tipo de massa com camadas alternadas de massa, queijo e molho de carne.','Lasanha','Tarde','100','Suldeste','https://destemperados.s3.amazonaws.com/arquivos/receita/846_564/lasanhabolonhesa_spoleto_divulgacao_2610834.jpg'),(5,140,'O Estrogonofe é um prato originário da culinária russa no século XIX, denominado de stroganov, chegou à França e, de lá, se espalhou para o mundo, tornando-se bastante popular no Brasil.','Estrogonofe','Tarde','100','Suldeste','http://www.receitasanamaria.net/wp-content/uploads/2014/08/Receita-Estrogonofe-de-Frango-F%C3%A1cil.jpg'),(6,142,'Prato originado de São Paulo, entre os séculos 17 e 18, pelos tropeiros que partiam da capital em direção ao interior do estado.','Cuscuz paulista','Manha','100','Suldeste','http://www.pilotandofogao.com.br/wp-content/uploads/2016/03/receita-de-cuscuz-paulista.jpg'),(7,146,'É um prato com origem no Norte de Portugal, e que, hoje em dia, é um dos pratos mais típicos da cozinha brasileira.','Feijoada','Tarde','100','Nordeste','http://www.kinadofeijaoverde.com.br/wp-content/uploads/2016/01/s71kefhb.jpg'),(8,187,'Com origem na época do Brasil Império, o prato começou como característica própria da cidade, sendo consolidado através do tempo como símbolo maior da identidade da gastronomia paranaense.','Barreado','Tarde','100','Sul','http://meumenuurbano.com/wp-content/uploads/2015/08/litoral-paranagua-8.jpg'),(9,165,'Prato da culinária afro-brasileira, muito popular no nordeste.','Bobó de camarão','Tarde','100','Nordeste','http://s.glbimg.com/po/rc/media/2013/08/16/09_09_01_257_Bob_de_camar_o1.jpg'),(10,66,'De origem indígena, é uma iguaria presente em toda a região amazônica brasileira.','Tacacá','Noite','100','Norte','http://vivaobrasil.com.br/wp-content/uploads/2013/10/tacaca11.jpg'),(11,367,'Até o século XVII o chocolate era servido somente na forma de bebida. A partir daí os confeiteiros ingleses começaram a estudar uma forma diferente de consumir o chocolate. Foi quando em 1674 eles tiveram a idéia de misturar cacau às misturas de bolos e servir a receita em empórios. ','Bolo de Chocolate','Tarde','100','Nordeste','http://vovopalmirinha.com.br/wp-content/uploads/2016/05/bolo-chocolate-simples-1.jpg'),(12,229,'Preparação culinária que chegou ao Brasil por meio dos imigrantes italianos, e, hoje, pode ser encontrada facilmente na maioria das cidades brasileiras., em diferentes sabores. ','Pizza','Noite','100','Nordeste','http://www.condedebonfim.com.br/wp-content/uploads/2016/06/pizza-page.png');
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alimento_componente_rel`
--

DROP TABLE IF EXISTS `alimento_componente_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alimento_componente_rel` (
  `id_alimento` bigint(20) NOT NULL,
  `id_componente` bigint(20) NOT NULL,
  KEY `FK_n6dplwlqc636j49oxcmpn1s4e` (`id_componente`),
  KEY `FK_i606nlxd77ubra9lwg8grpk18` (`id_alimento`),
  CONSTRAINT `FK_i606nlxd77ubra9lwg8grpk18` FOREIGN KEY (`id_alimento`) REFERENCES `alimento` (`id_alimento`),
  CONSTRAINT `FK_n6dplwlqc636j49oxcmpn1s4e` FOREIGN KEY (`id_componente`) REFERENCES `componente` (`id_componente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento_componente_rel`
--

LOCK TABLES `alimento_componente_rel` WRITE;
/*!40000 ALTER TABLE `alimento_componente_rel` DISABLE KEYS */;
INSERT INTO `alimento_componente_rel` VALUES (1,3),(1,11),(2,3),(2,8),(2,9),(2,12),(3,10),(3,3),(4,3),(5,7),(5,13),(5,8),(5,12),(6,6),(7,9),(7,12),(7,8),(8,12),(9,7),(9,1),(9,8),(10,7),(11,1),(11,2),(11,4),(11,5),(11,6),(12,2),(12,3);
/*!40000 ALTER TABLE `alimento_componente_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componente`
--

DROP TABLE IF EXISTS `componente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `componente` (
  `id_componente` bigint(20) NOT NULL AUTO_INCREMENT,
  `benef_componente` longtext,
  `ds_componente` longtext NOT NULL,
  `link_componente` varchar(200) NOT NULL,
  `malef_componente` longtext,
  `nm_componente` varchar(50) NOT NULL,
  `url_imagem_componente` varchar(200) NOT NULL,
  PRIMARY KEY (`id_componente`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componente`
--

LOCK TABLES `componente` WRITE;
/*!40000 ALTER TABLE `componente` DISABLE KEYS */;
INSERT INTO `componente` VALUES (1,'Cerca de 15% das pessoas possuem intolerância à lactose, além de o leite ser um alimento com muita gordura saturada – engorda e aumenta o colesterol.\r\nAlém disso, o processo de produção do leite envolve uma ingestão muito alta de hormônios do crescimento e antibióticos por parte das vacas e isso faz com que, consequentemente, a substância esteja presente no leite.\r\n','Líquido de cor esbranquiçada e opaca produzida pelas glândulas mamárias das fêmeas dos mamíferos, é muito consumido em vários países por seu poder nutritivo. Composição nutricional: colesterol, sódio, potássio, carboidratos, proteínas, vitamina A, C, D, B12, B6, cálcio, ferro, magnésio.','http://beneficiosnaturais.com.br/beneficios-e-maleficios-leite/','O leite é rico em proteína e a caseína presente no soro do leite contém 9 aminoácidos essenciais para o desenvolvimento humano. Também é rico em cálcio, essencial para a formação e manutenção da saúde dos ossos. Além disso, é rico em proteínas, carboidratos, vitamina B12 e potássio.','Leite','http://cakepot.com.br/wp-content/uploads/2016/01/10-curiosidades-sobre-o-leite-que-voc%C3%AA-n%C3%A3o-sabia.jpg'),(2,'A farinha de trigo branca deve ser evitada por pessoas com doença celíaca ou intolerantes ao glúten. Essa versão da farinha também engorda e traz riscos de obesidade, compulsão alimentar, diabetes e doenças crônicas, além de prejudicar o funcionamento do intestino. Por isso, o ideal é optar pela farinha de trigo integral.','Proveniente do trigo moído, é um pó desidratado rico em amido. É muito utilizada para a elaboração do pão, macarrão, bolos e mingaus e outros alimentos. Composição nutricional: carboidratos, proteínas, fibra alimentar, ácido fólico, ferro; no caso da versão integral, também é fonte de vitaminas do complexo B, zinco e potássio.','http://www.gulosoesaudavel.com.br/2013/07/29/o-trigo-aproveite-os-beneficios-desse-poderoso-alimento/','As vitaminas dão energia e vitalidade ao sistema nervoso central, enquanto que o zinco fortalece o sistema imunológico e o potássio auxilia na hidratação dos tecidos do corpo.','Farinha de trigo','http://foodsafetybrazil.org/wp-content/uploads/2016/03/farinha_de_trigo_integral_603x295_1.jpg'),(3,'Pessoas que possuem intolerância a lactose ou alergia a leite não podem consumir derivados do leite, incluindo o queijo. ','Alimento sólido feito a partir do leite de vacas, cabras, ovelhas, búfalas e/ou outros mamíferos. O queijo é produzido pela coagulação do leite. Composição nutricional: carboidratos, proteínas, sódio, cálcio, vitamina A, gorduras saturadas, ferro, magnésio, zinco, fósforo, potássio.','http://www.dicasnutricao.com.br/os-7-beneficios-do-queijo-para-saude/','O consumo moderado de queijo apresenta vários efeitos benéficos, como o fortalecimento dos ossos e saúde do coração, reduzindo as chances de osteoporose e hipertensão arterial, respectivamente.','Queijo','http://www.laticiniosestrela.com.br/marketing/Queijo-Minas-Padrao.jpg'),(4,'Os malefícios referem-se principalmente à quantidade de gordura e ao teor calórico, que acabam causando sérios problemas à saúde, como a obesidade por exemplo. Portanto, o ideal é optar pelos chocolates com maior teor de cacau, no caso os mais amargos e sempre analisar atentamente os rótulos nutricionais.','O chocolate é um alimento feito com base na amêndoa fermentada e torrada do cacau. Sua origem remonta às civilizações pré-colombianas da América Central. Composição nutricional: carboidrato, proteínas, gorduras saturadas, cálcio, magnésio, colesterol, lipídios, fósforo, potássio, sódio, zinco.','https://www.tuasaude.com/beneficios-do-chocolate/','Os benefícios do chocolate amargo ou meio amargo são, principalmente, melhorar a circulação sanguínea e prevenir o câncer, devido a sua riqueza em antioxidantes. Também promove sensação de bem estar, pois ajuda a libertar o hormônio serotonina. Quanto mais cacau o chocolate tiver, mais benefícios há para a saúde.','Chocolate','http://uploads.macacovelho.com.br/wp-content/uploads/2014/01/Chocolate.jpg'),(5,'Quando consumido em grande quantidade, o açúcar pode causar ganho de gordura e diabetes, que por sua vez pode levar a problemas neurológicos, cardiovasculares, nos olhos e nos rins.','De sabor adocicado, começou a ser produzido na Índia e atualmente está presente nos mercados do mundo todo. Composição nutricional: carboidratos, proteínas, cálcio, magnésio, ferro e potássio.','http://drauziovarella.com.br/diabetes/males-e-beneficios-do-acucar/','Sendo uma uma importante fonte de cálcio, fósforo, ferro, cloro, potássio, sódio, magnésio e de vitaminas do complexo B, é a forma mais rápida de fornecer glicose para o corpo, componente essencial para o funcionamento do cérebro, da retina e dos rins.','Açúcar','http://www.rodalewellness.com/sites/rodalewellness.com/files/articles/2015/10/sugar_cubes.jpg'),(6,'Se consumido excesso, pode elevar o colesterol ruim. O ideal é evitar comer cru ou mal cozido, para não haver contaminação por Salmonella, bactéria que pode estar presente no ovo.','Ovo é um alimento de origem animal, podendo ser de diversas espécies animais, incluindo aves, répteis, anfíbios e peixes. Os ovos de galinha são os mais consumidos pelos humanos. Composição nutricional: carboidratos, proteínas, gorduras, cálcio, vitamina A, magnésio, colesterol, lipídios, fósforo, potássio, sódio.','http://docedieta.com/saude/beneficios-ovos-galinha-alimentacao-saudavel/','Os ovos são um dos únicos alimentos que contêm naturalmente a Vitamina D. Também têm grandes benefícios para os olhos e podem prevenir o câncer de mama. Em um estudo, as mulheres que consumiam pelo menos seis ovos por semana reduziu o risco de câncer de mama em 44%.','Ovos','http://www.dietaesaude.com.br/areas/buscaalimento/content/handlers/dietaimagem.ashx?id=2&tipo=i'),(7,'O consumo de camarão também tem algumas desvantagens que podem afetar sua saúde cardiovascular: O camarão é rico em sódio e colesterol, por isso é necessário o consumo moderado.','O camarão é um fruto do mar delicioso e que se inclui em várias opções de pratos maravilhosos, seja como petiscos ou como risotos. Composição nutricional: proteínas, cálcio, magnésio, colesterol, fósforo, ferro, potássio, zinco, sódio.','http://www.saudedica.com.br/os-beneficios-do-camarao-para-saude/','O Camarão pode ser pequeno em tamanho, mas são enormes em termos de valor nutricional e oferecem diversos benefícios para saúde, como qualidades anti-inflamatórias, ajuda no funcionamento adequado do cérebro musculatura cardiovascular.','Camarão','http://foodsafetybrazil.org/wp-content/uploads/2015/05/camarao.jpg'),(8,'Arroz branco ajuda o desenvolvimento da Diabetes tipo 2. O consumo exagerado de arroz pode aumentar drasticamente o peso de um indivíduo que tem certa facilidade para engordar.','É uma planta da família das gramíneas que alimenta mais da metade da população humana do mundo. É a terceira maior cultura cerealífera do mundo, apenas ultrapassada pelas de milho e trigo. Composição nutricional: carboidratos, proteínas, fibra alimentar, cálcio, fósforo, magnésio, potássio, zinco e sódio.','https://www.tuasaude.com/beneficios-do-arroz/','Os benefícios do arroz são fornecer energia ao organismo com carboidratos e proteínas saudáveis.Os benefícios do arroz integral estão relacionados com a diminuição do aparecimento de doenças como câncer, diabetes, doenças cardiovasculares e obesidade. O arroz integral possui muito mais nutrientes.','Arroz','https://1.bp.blogspot.com/-KeSDII2H2N8/V2mQ4_Qcd6I/AAAAAAAAGj0/zLOGJRKsmJ0_LTKPDQ93ZBCZw6oQ_ui6ACLcB/s1600/arroz_branco.png'),(9,'Assim, como qualquer outro alimento, não deve ser consumido em quantidades exageradas ao dia, podendo levar a problemas digestivos.','O feijão-comum é a base de várias sopas e da feijoada, misturado com arroz. Proporciona nutrientes essenciais como proteínas, ferro, cálcio, vitaminas (principalmente do complexo B), carboidratos e fibras. ','http://docedieta.com/saude/beneficios-do-feijao-saudavel/','O feijão melhora o funcionamento do intestino, diminui o risco de câncer, equilibra o açúcar no sangue e ajuda a ter um coração saudável.','Feijão','http://www.guiachef.com.br/wp-content/uploads/2014/03/feij%C3%A3o.jpg'),(10,'Como todo carboidrato, se consumido em excesso pode provocar diabetes, aumento de colesterol e triglicérides e, claro, engordar.','Massa muito comum nas mesas brasileiras, principalmente na refeição do almoço, é uma rica fonte de carboidratos. ','http://revistavivasaude.uol.com.br/nutricao/coma-macarrao-todo-dia/535/#','Fundamental como fonte de energia, também é importante como combustível do sistema nervoso central. A dieta rica em carboidratos aumenta os estoques corporais nos músculos e no fígado, auxilia o sistema imunológico e proporciona energia antes, durante e depois de atividades físicas. ','Macarrão','http://www.cybercook.com.br/imagens/receitas/rc_f8_3886.jpg'),(11,'Algumas espécies contêm substâncias tóxicas, como a mandioca brava. Suas raízes e folhas, quando mal processadas, liberam o cianeto de hidrogênio. Para evitar que isso aconteça, a macaxeira/mandioca precisa ser preparada com cuidado e existem diferentes maneiras de retirar o veneno: desde cozinhar a fermentar. ','Macaxeira, mandioca ou aipim, são alguns dos diversos nomes pelos quais é conhecida essa raiz que possui alto valor nutricional.O Brasil é a terra natal da mandioca. Do centro do país, o tubérculo se espalhou por mais de 100 nações desde a chegada dos portugueses. Sua importância era tanta nos tempos de colônia que o padre José de Anchieta a batizou como o \"pão da terra\". Composição nutricional: carboidrato, proteína, fibra alimentar, cálcio, fósforo, magnésio, potássio, zinco, vitamina C.','http://www.debemcomabalanca.com.br/blog/o-poder-da-macaxeira','A macaxeira possui em sua composição dois tipos de carboidratos: Amilopectina e Amilose que juntos liberam a glicose lentamente, evitando assim picos glicêmicos, por isso é ideal para os diabéticos. Também promove o aumento da serotonina, que é um neurotransmissor que age nas regiões do cérebro, promovendo a sensação de bem estar.','Macaxeira','http://www.aquinacozinha.com/wp-content/uploads/2013/04/Como+cozinhar+macaxeira+6.jpg'),(12,'Os malefícios causados pelo consumo da carne vermelha estão, em geral, ligados ao consumo exagerado e predominantemente de cortes gordos, ricos em gorduras saturadas e colesterol. Também é necessário saber que apenas o consumo da carne vermelha não supre todas as necessidades do organismo, tendo o seu consumo que estar aliado a outros alimentos, como frutas, legumes e verduras.','A carne vermelha, provenientes dos mamíferos, é rica em nutrientes fundamentais para o bom funcionamento do organismo humano e o seu desenvolvimento. Composição nutricional: proteínas, gorduras, cálcio, magnésio, colesterol, lipídios, fósforo, ferro, potássio, zinco, sódio.','http://www.minhavida.com.br/alimentacao/materias/13475-compare-os-beneficios-e-maleficios-da-carne-vermelha','É o alimento que concentra a maior quantidade de ferro, sendo assim um bom combatente à anemia, é também fonte de proteínas, que são importantíssimas para o desenvolvimento dos músculos, órgãos e tecidos, e contém zinco, um mineral que contribui para o bom funcionamento do metabolismo de proteínas, carboidratos, lipídeos e ácidos nucleicos. Por possuir grande quantidade de vitaminas do complexo B,','Carne vermelha','http://www.maisequilibrio.com.br/imagens/maisequilibrio/default/2008/10/06/a-carne-vermelha-e-prejudicial-a-saude-1-112.jpg'),(13,'Em frangos não há aplicação de hormônios de crescimento, mas sim de antibióticos. Assim, há controvérsias de que o alto consumo de frango possa ser prejudicial devido a estas substâncias presentes no mesmo.','Em geral a carne de frango é menos gordurosa e mais leve que as carnes vermelhas, sendo o seu consumo mas incentivado por nutricionistas e dietéticos. Entretanto, a quantidade de proteína é inferior à da vermelha. Composição nutricional: proteínas, gorduras, cálcio, vitamina A, magnésio, colesterol, lipídios, fósforo, ferro, potássio, zinco, sódio, vitamina B3.','http://www.saudedica.com.br/os-6-beneficios-do-frango-para-saude/','O Frango é rico em Niacina (vitamina B3), uma vitamina que é essencial para a proteção contra o câncer e saúde do cérebro. O frango também ajuda a prevenir doenças do tecido, regula a saciedade e fortalece o sistema imunológico.','Frango','http://www.mundoboaforma.com.br/wp-content/uploads/2013/12/peito-de-frango.jpg'),(14,'Além do modo de preparo que é necessário acertar para que não se percam vitaminas e para que o alimento não ganhe gordura evitando a utilização de gorduras saturadas e trans, existem outros cuidados a serem tomados no que se refere ao consumo de peixes. Um dos problemas é o nível de mercúrio que pode existir na carne dos pescados. ','Descrição: Sendo uma boa fonte de proteínas, é recomendável consumir peixe pelo menos 2 vezes por semana. Composição nutricional: proteínas, gorduras, cálcio, magnésio, colesterol, lipídios, fósforo, potássio, vitamina B3, sódio.','http://www.renatocapellari.com.br/beneficios-e-maleficios-do-pexe/','Os principais benefícios de comer peixe, além de ser uma alimento de fácil digestão, envolve melhorar a memória, a concentração, prevenir doenças cardiovasculares e aumentar as reações anti-inflamatórias do organismo porque o peixe é rico em ômega 3, que é um componente importante para todos estes processos. ','Peixe','http://3.bp.blogspot.com/-2bgPV6pfWCc/UbnwJMoK1_I/AAAAAAAADyc/64mgSDRoDCY/s1600/peixe02.png');
/*!40000 ALTER TABLE `componente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionario`
--

DROP TABLE IF EXISTS `questionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionario` (
  `id_questionario` bigint(20) NOT NULL AUTO_INCREMENT,
  `altura` double NOT NULL,
  `idade` int(11) DEFAULT NULL,
  `imc` double NOT NULL,
  `nm_usuario` varchar(40) NOT NULL,
  `peso` double NOT NULL,
  `regiao_usuario` varchar(30) NOT NULL,
  PRIMARY KEY (`id_questionario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionario`
--

LOCK TABLES `questionario` WRITE;
/*!40000 ALTER TABLE `questionario` DISABLE KEYS */;
INSERT INTO `questionario` VALUES (1,1.45,34,42.8,'fsfsd',90,'Nordeste');
/*!40000 ALTER TABLE `questionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questionario_alimento_rel`
--

DROP TABLE IF EXISTS `questionario_alimento_rel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questionario_alimento_rel` (
  `id_questionario` bigint(20) NOT NULL,
  `id_alimento` bigint(20) NOT NULL,
  KEY `FK_ejan9t075sp6jcutt4iwvtq99` (`id_alimento`),
  KEY `FK_gqpnn6mdu8e25h1ckuntn18gi` (`id_questionario`),
  CONSTRAINT `FK_ejan9t075sp6jcutt4iwvtq99` FOREIGN KEY (`id_alimento`) REFERENCES `alimento` (`id_alimento`),
  CONSTRAINT `FK_gqpnn6mdu8e25h1ckuntn18gi` FOREIGN KEY (`id_questionario`) REFERENCES `questionario` (`id_questionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questionario_alimento_rel`
--

LOCK TABLES `questionario_alimento_rel` WRITE;
/*!40000 ALTER TABLE `questionario_alimento_rel` DISABLE KEYS */;
INSERT INTO `questionario_alimento_rel` VALUES (1,2);
/*!40000 ALTER TABLE `questionario_alimento_rel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sugestao`
--

DROP TABLE IF EXISTS `sugestao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sugestao` (
  `idAlimento` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  `tipo_sugestao` varchar(30) NOT NULL,
  PRIMARY KEY (`idAlimento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sugestao`
--

LOCK TABLES `sugestao` WRITE;
/*!40000 ALTER TABLE `sugestao` DISABLE KEYS */;
INSERT INTO `sugestao` VALUES (1,'i','Alimento'),(2,'i','Alimento'),(3,'dasdasdsa','Componente'),(4,'esfdsfsd','Alimento');
/*!40000 ALTER TABLE `sugestao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'viversaudavel'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-30 11:55:29
