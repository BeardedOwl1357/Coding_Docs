YT-DLP is a commandline tool to download youtube videos and playlists almost effortlessly. You can see the project from here : https://github.com/yt-dlp/yt-dlp

Table of Contents
- [Resources- Resources](#resources--resources)
- [Commands](#commands)
  - [Updating Via CLI](#updating-via-cli)
  - [Downloading a youtube playlist and saving each video in the same format as the playlist](#downloading-a-youtube-playlist-and-saving-each-video-in-the-same-format-as-the-playlist)

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
