   @Value("${git.commit.message.short}")
    private String commitMessage;

    @Value("${git.branch}")
    private String branch;

    @Value("${git.commit.id}")
    private String commitId;
 
    
    @Value("${git.commit.time}")
    private String timeStamp;
    
    @Value("${git.build.version}")
    private String buildVersion;


 @GetMapping("/buildInfo")
    public Map<String, String> getCommitId() {
        Map<String, String> result = new HashMap<>();
        result.put("Commit message", commitMessage);
        result.put("Commit branch", branch);
        result.put("Commit id", commitId);
        result.put("Time Stamp", timeStamp);
        result.put("Version No", buildVersion);
        return result;
    }

	@Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setLocation(new ClassPathResource("git.properties"));
        c.setIgnoreResourceNotFound(true);
        c.setIgnoreUnresolvablePlaceholders(true);
        return c;
    }

<properties>
		 <git-commit-id-plugin.version>4.0.4</git-commit-id-plugin.version>
	</properties>
  
  <plugin>
				<groupId>pl.project13.maven</groupId>
				<artifactId>git-commit-id-plugin</artifactId>
				<executions>
					<execution>
						<id>get-the-git-infos</id>
						<goals>
							<goal>revision</goal>
						</goals>
						<phase>initialize</phase>
					</execution>
					<execution>
						<id>validate-the-git-infos</id>
						<goals>
							<goal>validateRevision</goal>
						</goals>
						<phase>package</phase>
					</execution>
				</executions>
				<configuration>
					<generateGitPropertiesFile>true</generateGitPropertiesFile>
					<generateGitPropertiesFilename>${project.build.outputDirectory}/git.properties</generateGitPropertiesFilename>
				</configuration>
			</plugin>
