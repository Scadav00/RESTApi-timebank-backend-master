Inštalácia Javy na Debiane 11
=============================


	sudo apt update && sudo apt upgrade -y
	sudo apt install openjdk-17-jdk

Overenie, že Java funguje:

    java -version

Príprava backendovej infraštruktúry na serveri
==============================================

1. Prihlásiť sa cez `ssh` alebo `putty` na server
2. Prepnúť sa na `root`-a.

        sudo su -

3. Vytvoriť používateľa a skupinu `app` pre beh aplikácie

        useradd --no-create-home app
        usermod -a -G app app

4. Vytvoriť adresáre pre backend a nastaviť oprávnenia

        mkdir -p /opt/timebank-backend
        chown -R app:app /opt/timebank-backend/
        chmod g+w /opt/timebank-backend/
        chmod g+s /opt/timebank-backend/
        chmod g+x /opt/timebank-backend/
        chmod u+x /opt/timebank-backend/

5. Vytvoriť konfigurák pre systémovú službu cez `systemd`.

        touch /etc/systemd/system/timebank-backend.service

6. Editorom upraviť:

        vim /etc/systemd/system/timebank-backend.service

   Obsah súboru musí byť:

       [Unit]
       Description=Timebank Service
       After=syslog.target

       [Service]
       User=app
       ExecStart=/opt/timebank-backend/timebank-0.0.1-SNAPSHOT.jar
       SuccessExitStatus=143

       [Install]
       WantedBy=multi-user.target

7. Povoliť automatické spúšťanie:

        systemctl enable timebank-backend.service

8. Spustiť službu, i keď prvý beh zlyhá:

        systemctl enable timebank-backend.service

9. Pozrieť si logy, ktoré indikujú zlyhanie

        systemctl status timebank-backend.service

10. Po prvom uploade JAR súboru cez `scp`/`WinSCP`:

        chmod og+x timebank-0.0.1-SNAPSHOT.jar

11. Spustenie / reštart služby

        systemctl restart timebank-backend.service