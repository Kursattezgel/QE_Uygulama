Cucumber ve TestNG ile Otomasyon Testi Projesi
Bu proje, Cucumber ve TestNG kullanarak geliştirilmiş bir otomasyon testi framework'üdür. Proje, Java dilinde yazılmış olup, otomasyon testlerinin yönetimi ve raporlanması için kapsamlı araçlar ve sınıflar içermektedir.

Proje Yapısı

1. Ana Klasörler ve Sınıflar
•	src/main/java/
o	runner: Testlerin çalıştırılmasını sağlayan Runner sınıfı.
o	util: Yardımcı sınıfların bulunduğu paket. (ConfigReader, DriverFactory, ElementHelper, ExtentReportManager, Hooks)
•	src/test/
o	config.properties: Proje yapılandırma dosyası.
o	log4j.properties: Loglama yapılandırma dosyası.
o	stepDefinitions: Test adımlarının tanımlandığı klasör.
o	features: Cucumber test özellik dosyaları (.feature)

3. Önemli Sınıflar
•	Runner:
Cucumber testlerinin çalıştırılmasını sağlayan sınıf. TestNG ile entegre bir şekilde çalışarak, Cucumber senaryolarını test ortamına aktarır.
•	ConfigReader:
Yapılandırma dosyasından (config.properties) çeşitli ayarları okur. Örneğin, test ortamı, URL, vb.
•	DriverFactory:
WebDriver'ların yönetildiği sınıf. Farklı tarayıcı türlerine göre uygun WebDriver'ları başlatmak için kullanılır.
•	ElementHelper:
Web sayfasındaki elementler ile etkileşim sağlayan yardımcı sınıf. Elementlerin bulunması, tıklanması, metin girilmesi gibi işlemleri kapsar.
•	ExtentReportManager:
Test sonuçlarının raporlanmasından sorumlu sınıf. Testlerin başarılı, başarısız, ya da hata almış olmasına göre ayrıntılı raporlar oluşturur.
•	Hooks:
Test öncesi ve sonrası işlemleri kontrol eden sınıf. Testlerin başlatılması, sonlandırılması, ekran görüntülerinin alınması gibi işlemleri içerir.

5. Konfigürasyon Dosyaları
•	config.properties:
Testlerin çalışabilmesi için gerekli olan çeşitli yapılandırmaları içerir. Örneğin, testlerin çalışacağı URL, tarayıcı tipi gibi bilgiler burada belirtilir.
•	log4j.properties:
Loglama ayarlarını tanımlar. Bu dosya sayesinde, testler sırasında log seviyeleri belirlenebilir ve testlerin çıktıları dosyaya kaydedilebilir.
6. TestNG XML Dosyası
•	testng.xml:
TestNG tarafından kullanılan yapılandırma dosyasıdır. Testlerin nasıl çalıştırılacağı, hangi sınıfların test edileceği, gruplar ve paralel testler gibi ayarlar burada tanımlanır.
________________________________________
Projeyi Çalıştırma
Adım 1: Gerekli Bağımlılıkları Yükleyin
Proje, Maven kullanarak bağımlılıkları yönetmektedir.
Adım 2: Testi Çalıştırma
Projede yer alan testleri çalıştırmak için, aşağıdaki komut ile TestNG'yi kullanabilirsiniz:
________________________________________
Test Raporları
Projenin raporlama mekanizması ExtentReports ile sağlanmaktadır. Testler tamamlandıktan sonra, aşağıdaki gibi bir rapor oluşturulur:
<proje_dizini>/test-output/ExtentReport.html
Bu dosya, testlerin başarısı, başarısızlığı ve ilgili log bilgilerini içeren detaylı bir rapor sunar.
________________________________________
Yapılandırma ve Özelleştirmeler
1. Tarayıcı Ayarları
Testlerin çalışacağı tarayıcıyı config.properties dosyasındaki browser parametresi ile belirleyebilirsiniz. Varsayılan olarak Edge tarayıcısı kullanılmaktadır.
Örnek:
properties
browser=edge
Diğer Tarayıcılar:
•	firefox
•	chrome

2. Log Seviyesi
Loglama seviyesini log4j.properties dosyasından değiştirebilirsiniz. Farklı log seviyeleriyle testlerinizi daha ayrıntılı inceleyebilirsiniz.
3. Config Ayarları
config.properties dosyasındaki test ortamı URL'sini değiştirebilirsiniz. Örnek:
properties
url = https://catchylabs-webclient.testinium.com/signIn
________________________________________
Kullanılan Teknolojiler
•	Cucumber: BDD (Behavior-Driven Development) için kullanılan test framework'ü.
•	TestNG: Testlerin paralel olarak çalıştırılmasını sağlayan test framework'ü.
•	Selenium WebDriver: Web uygulamalarını test etmek için kullanılan otomasyon aracı.
•	Maven: Proje bağımlılıklarını yönetmek için kullanılan yapı yönetim aracı.
•	ExtentReports: Test raporlama aracıdır.
•	Log4j: Loglama için kullanılan kütüphane.

Özet:
Src/main/java/testRunners klasöründe runner sınıfı var, burada tags kısmına Feature dosyalarındaki tagleri yazıp tek tek çalıştırabiliriz.
Src/main/java/Util klasörünün içindeki DriverFactory dosyasında screenshot alan fonksiyonumuz yer alıyor.
Src/main/java/Util klasörünün içindeki ElementHelper sınıfında temel fonksiyonlarımız yer alıyor.
Src/main/java/Util klasörünün içindeki ExtentReportManager sınıfında raporlama entegremiz bulunuyor. Rapor ve screenshotlar projede oluşan test-output klasörünün içinde yer alıyor.
Pages klasöründe Steplerimizin fonksiyonları bulunuyor.
Pom.xml dosyasından dependency bilgilerini inceleyebilirsiniz.
Projeyi TestNG.xml dosyasından çalıştırabilirsiniz.


