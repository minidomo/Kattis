# KattisTableGenerator
## Background Information
This was a solo project I wanted to do because I wanted this repository to have a table that would show all the problems I solved on [Kattis](https://open.kattis.com/). This project was coded in C# using [.NET Core 2.1](https://www.microsoft.com/net/download) specifically v2.1.300 and was programmed in [Visual Studio Code](https://code.visualstudio.com/). It was my first time doing a C# project, so it took me a long time to figure out how to use `dotnet` in the command line and how to properly setup my `.csproj`. As you can see, I am not very experienced at the moment.

## How It works
This program is a console application, and it creates a table in markdown of the Kattis problems you solved. It works by using `WebRequest` and `WebResponse` in the `System.Net` namespace and getting the stream of the html code of the website.

First, it gets the stream of the `GithubLinks.txt`, and loops through the stream for the hyperlink that contains the URL to your solution. It then gets the filename from the end of the URL and uses it to identify the programming language it was coded in and get the Kattis problem ID. It will use the problem ID and get the Kattis URL to the problem, which is then passed to a stream to find the name of the problem. Once it's been found, it'll be added it to a list and continue until all links have been searched. Afterwards, it'll sort the list alphabetically and format the information into a table.

Here's the [source code](https://github.com/MiniDomo/Kattis/tree/master/KattisTableGenerator).

If you want the whole C# project, I'll upload a download here in a couple of days.

## How To Use
I made this using Windows 10 and do not have access to an Apple device, so I am unable to check if it is compatible with macOS.  You can start using this program by downloading it [here](https://github.com/MiniDomo/Kattis/releases/tag/Kattis-Table-Generator-v1.0.0) or this [direct download](https://github.com/MiniDomo/Kattis/archive/Kattis-Table-Generator-v1.0.0.zip).

Once you extract the files, you will see a `GithubLinks.txt` file where you will put your links to your github folder that has your code and the KattisTableGenerator.exe. Additionally, you can leave comments in the file by starting the line with `#` or `//`, and it'll also ignore lines that are blank. To run it, you simply open the exe, and it'll start working on generating the table and display some information in the console as it goes. Once the program is finished, it'll output a `LatestLog.txt` and a `README.md` file. The `README.md` will contain the table that you can freely modify if you so desire, and the `LatestLog.txt` will contain the same information as what was outputted to the console.