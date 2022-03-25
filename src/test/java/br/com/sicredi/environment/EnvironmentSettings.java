package br.com.sicredi.environment;


import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentSettings {

    private Dotenv dotenv = null;

    public EnvironmentSettings(String path){
         this.dotenv = Dotenv.
                configure().
                directory(path).             // path to the environment file that contains variables to be loaded
                        ignoreIfMalformed(). // Ignore malformed entries in .env file
                        ignoreIfMissing().   // Ignore if .env file is not present in given path
                        load();              // Load variables decribed in file to current environment
    }

    public String get(String variable){
        return this.dotenv.get(variable);
    }
}
