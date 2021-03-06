# 마인크래프트 '메세지 플러그인'
[![GitHub all releases](https://img.shields.io/github/downloads/sukkot23/R-JoinMessage/total?color=mint&style=plastic)](https://github.com/sukkot23/R-JoinMessage/releases/download/1.0.0_1.16.4/R-JoinMessage-1.16.4.jar)
[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fsukkot23%2FR-JoinMessage&count_bg=%23597ED0&title_bg=%23555555&icon=github.svg&icon_color=%23E7E7E7&title=View&edge_flat=false)](https://hits.seeyoufarm.com)

## 플러그인 정보
```
Name : R-JoinMessage
Version : 1.0.0
MC-Version : 1.16.4
Update : 2021. 01. 06
```

</br>

```
- 본 플러그인은 Spigot API에 의해 GPLv3 라이선스를 사용하고 있습니다
- 파일 공유 시 현 깃허브 링크 형태로 공유해주시길 바랍니다
- 소스 사용 시 반드시 출처를 기재해주세요
- 버그 발견 시 Issues에 제보해주시면 재업로드 하겠습니다

https://github.com/sukkot23/R-JoinMessage
```

</br>

## 플러그인 설명서
```
입장(Join), 퇴장(Left), 강퇴(Kick), MOTD(Message Of The Day) 메세지를 변경해주는 플러그인 입니다

 사용 : R-JoinMessage 폴더내의 config.yml 파일을 수정합니다
```

</br>

## Configuration
```
# 메세지 출력 여부를 결정합니다 (false로 설정시 메세지가 출력되지 않습니다) 
setting:
  print-JoinMessage: true
  print-LeftMessage: true
  print-kickMessage: true

# 이벤트 호출 시 출력되는 메세지를 변경할 수 있습니다
# 색코드 입력시 & 기호를 사용할 수 있습니다
# 1.16부터 지원되는 HexCode는 &x[&:Hex]로 입력가능합니다 (예시: &x&F&F&F&F&F&F)
# 플레이어 이름은 `PLAYER`, 사유는 `REASON` 구문으로 입력할 수 있습니다
messages:
  first-join: "&d`PLAYER` join the game for the first time"
  join: "&e`PLAYER` joined the game"
  left: "&e`PLAYER` left the game"
  kick: "&f`PLAYER` kicked the game \n&c reason: `REASON`"

# MOTD를 변경할 수 있습니다
# 폰트에 따라 MOTD가 달라보일 수 있습니다
# line1의 글자수가 많을 경우 잘림현상이 나타날 수 있습니다
motd:
  line1: "&7A Minecraft Server"
  line2: ""
```

</br>

[![GitHub all releases](https://img.shields.io/github/downloads/sukkot23/R-JoinMessage/total?color=83BD17&label=DOWNLOAD&style=for-the-badge)](https://github.com/sukkot23/R-JoinMessage/releases/download/1.0.0_1.16.4/R-JoinMessage-1.16.4.jar)
