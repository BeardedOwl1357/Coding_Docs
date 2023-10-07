YT-DLP is a commandline tool to download youtube videos and playlists almost effortlessly. You can see the project from here : https://github.com/yt-dlp/yt-dlp

Table of Contents
- [Resources- Resources](#resources--resources)
- [Commands](#commands)
  - [Updating Via CLI](#updating-via-cli)
  - [Downloading a youtube playlist and saving each video in the same format as the playlist](#downloading-a-youtube-playlist-and-saving-each-video-in-the-same-format-as-the-playlist)
  - [Downloading Several Youtube Playlists And Organizing Them In Their Respective Folders](#downloading-several-youtube-playlists-and-organizing-them-in-their-respective-folders)
  - [Categorizing Videos Based On Channel](#categorizing-videos-based-on-channel)

# Resources- [Resources](#resources)

| Type | URL |
| ----------------- | ------------------- | 
| List of Format Specifiers | https://github.com/yt-dlp/yt-dlp#output-template |
| List of Video Formats | https://github.com/yt-dlp/yt-dlp#format-selection |

# Commands

## Updating Via CLI
Do this everytime you use yt-dlp as it constantly updates because youtube updates constantly
> When youtube updates, the procedure for downloading videos and playlists change. Thus, keep updating yt-dlp constantly

```
yt-dlp -U # Shorthand command
yt-dlp --update # Long command
```

## Downloading a youtube playlist and saving each video in the same format as the playlist
The format of the output will be like
`(index) - (name).(mp4)`

The command is as follows
```
yt-dlp <playlist_url> -f "%(playlist_index)s - %(title).mp4" -f mp4
```

## Downloading Several Youtube Playlists And Organizing Them In Their Respective Folders
I am assuming that the playlist links are present in a file called `yt-links.txt`. A sample of how the file should look like is as follows
```
https://www.youtube.com/playlist?list=PLG4bwc5fquzgmP5BLHrRDwBueer0udDjc
https://www.youtube.com/playlist?list=PLG4bwc5fquzj0Rkn0DVWZP9FxF9iG7OgB
https://www.youtube.com/playlist?list=PLG4bwc5fquziUvO3dlzG0MW9vqi3epud4
https://www.youtube.com/playlist?list=PLG4bwc5fquzgkOZZOd21O_jm_YwRJQ8t3
https://www.youtube.com/playlist?list=PLG4bwc5fquzio-ijSv5E5ijVMXe64ardb
https://www.youtube.com/playlist?list=PLG4bwc5fquzhDp8eqRym2Ma1ut10YF0Ea
https://www.youtube.com/playlist?list=PLG4bwc5fquzhzt4w7EZVc31G5VsQ4JbPo
https://www.youtube.com/playlist?list=PLG4bwc5fquzgF04E7Bm2JvZzAFx1uAEmM
https://www.youtube.com/playlist?list=PLG4bwc5fquzhuBJH3SrTY9SAmNVIFCOcU
https://www.youtube.com/playlist?list=PLG4bwc5fquzh6G9DHdfrZ-Yl6nQhsMwGr
https://www.youtube.com/playlist?list=PLG4bwc5fquziFHfEeGgOP-jU3_HqD68sV
https://www.youtube.com/playlist?list=PLG4bwc5fquzjyv86kYn0ao6LOx4Emz8tH
```

In bash (for windows, use Gitbash or WSL), the command which you need to execute is as follows
```bash
# Full Path of the destination where we will download the videos
YT_DLP_OUTPUT_PATH='/e/%(playlist_title)s/%(playlist_index)s_%(title)s.%(ext)s'
# Read each link and download
while read -r LINK; do echo $LINK; yt-dlp.exe $LINK -o $YT_DLP_OUTPUT_PATH -f mp4 ; done < yt-links.txt
```
Reference : [ubuntu 14.04 - youtube-dl | Download playlist in respective directory - Super User](https://superuser.com/questions/993993/youtube-dl-download-playlist-in-respective-directory)

## Categorizing Videos Based On Channel
Assuming that we have a file called `links.txt` which contains youtube links, the script below downloads the videos
```bash
# Full Path of the destination where we will download the videos
YT_DLP_OUTPUT_PATH="/e/%(channel)s/%(title)s.%(ext)s"
# Read each link and download
while read -r LINK; do yt-dlp.exe $LINK -o $YT_DLP_OUTPUT_PATH -f mp4; done < links.txt
```
