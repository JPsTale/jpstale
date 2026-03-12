#!/bin/bash
python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/account.h \
  ../src/main/java/org/jpstale/server/common/protocol/account

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/packets.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/socket.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/warehouse.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/unit.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/user.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/skill.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/roll.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/quest.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/party.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/map.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/item.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/chat.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/character.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/coin.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct

python3 ./gen_packet_structs_full.py \
  ~/repo/PristonTale-EU-main/shared/CStable.h \
  ../src/main/java/org/jpstale/server/common/protocol/struct