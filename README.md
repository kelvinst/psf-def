# psf-def

So, someday I needed this API and the eclipse existent is complex and statefull, then I create this.

This project contains an API for access the eclipse's *.psf* files content with a more abstract interface.

Actually the project only read the information, but nothing prevent's me to from evolving it to a file *savior*. :laughing:

## Providers

The eclipse team plugin saves the projects inside tags named **provider**, the providers have an id attribute where the provider type are saved.

This types determines *what factory* eclipse team plugin uses to read the project tag content and import it. And I need it to determine *how to build SCM infos* to the project definition.

Actually, the provider types supported are:

- Git
- Cvs
- Svn

## Working Sets

Eclipse also saves working sets in psf files if you want to. They are saved with the type of it, to, when importing them, create the correct type of working set.

I parse it and save in the working set definition too. The working set types allowed until now are:

- Java
- Resources

## Contributors

Give a look [at here](https://github.com/kelvinst/psf-def/contributors). Feel free to fork and make PRs please. :smiley:

## License

The [MIT License](LICENSE).
