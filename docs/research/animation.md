
## different-smb-data

https://forum.ragezone.com/threads/different-smb-data.968487/

```
Drz:
Hello community,

i'm trying to load PT models (smd, smb, inx) data in my graphics engine and it works fine 
 for the most of the models (monsters). But some of the smb data (characters m1.smb, m2.smb etc)
 appear to be buggy and draw broken animations. Does anyone know if there are different
 versions of the files smb data or different smb data structures?
```

```
SunnyZ:
wow, those npcs are TINY on the map haha.

But as we have no idea what engine you are using, what formats it uses. I doubt anyone can help atm.

The main smd/smb converter is sandurrs creation here: http://forum.ragezone.com/f399/sandurrs-smd-converter-736316/

You can export the animation file bones from the smb files with this tool to *.ASE format. Not sure if this helps...

Thoes m1/m2/m4.smb files are all the characters animation skills/walk/everything in one, a lot
 more complex than the monsters animation files. You are beter of working with the simpler
 m1-motion which usually just contain 1 motion.
```

```
Drz:
I've found the error with m_xx.smb. There are different sub animation sets wich wont parse
 by my smd parser. These different animation sets are marked by key frames with same time-key 
 in the smb files and a SubAnimationID in the .inx files. I'm try to fix this currently.
```
## DrzModelViewer

https://forum.ragezone.com/threads/release-drzmodelviewer.1048414/

## sandurrs-smd-converter

https://forum.ragezone.com/threads/sandurrs-smd-converter.736316/

## Model and Texture Viewing + PT File Naming Info - Quick Start

https://forum.ragezone.com/threads/model-and-texture-viewing-pt-file-naming-info-quick-start.1212715/

Quick guide to viewing Pristontale models and textures plus how to find specific model files.

For Textures/Skins:
You have two images, .BMP and .TGA
Can use Bobsobols "PT File Patcher" to patch them to readable format.
Available at: https://forum.ragezone.com/f399/pt-file-patcher-684994/
Edit .BMP in your favourite image editor
Edit .TGA in Adobe Photoshop

.SMD Conversion:
Convert .SMD to .ASE using sandurrs converter: https://forum.ragezone.com/f399/sandurrs-smd-converter-736316/
Then you can use 3ds Max with .ASE plugin to open the file (Avaliable at same link above)

For Weapon Models:
You have .SMD which are the 3d model files
Can convert weapon .SMD files to .ASE with sandurrs convert posted above.
These are super easy to edit/modify/create your own.

For Armor Models:
You have .SMD which are the 3d model files
.SMB which are the bone/animation files
Can convert combo .SMD and .SMB files to .ASE with sandurrs convert posted above.
For armours it is a tad more complicated as you need to convert the .SMD with a correct .SMB of the same file name (armor.SMD + armor.SMB)
Can get the .SMB files from TMACBD folder

Lots of info on armor files available here: https://forum.ragezone.com/f562/notes-armors-armors-101-a-789886/

Following smb relate to particular char type;

// m1.smb - Knight, Mechanician, Fighter
// m2.smb - Atlanta, Archer
// m3.smb - Magican
// m4.smb - Pikeman
// m5.smb - Priestess
// m6.smb - Assassin
// m7.smb - Shaman
// m8.smb - MartialArtist

Here are some original .ASE files that will import into 3DS Max with bones.

School Costumes
https://iinet.pristonworld.com/PristonTale/PT_School_Costumes.rar

Martial Artist armors
https://iinet.pristonworld.com/PristonTale/Martial_Artist_ASE.rar



Model Naming Schemes:

TM = Tempskron and Morion
ABCDEF = Characters:
A - Mechanician
B - Fighter
C - Pikeman
D - Archer
E - Assassin
F - Martial Artist

mA - Knight
mB - Atalanta
mC - Priestess
mD - Magician
mE - Shaman

Example:
CTFBD36
C = Costume
T = Tempskron
F = Female
B = Body
D = Archer
36 = costume 36

## Notes on Armors (Armors 101)

https://forum.ragezone.com/threads/notes-on-armors-armors-101.789886/

```
ScreamingFox:

Here are some stuff i've learned so far about making armors =D


To export the armor properly, you need to use the Sandurr Ase exporter (which supports physique).


This exporter works only on 3dsmax 5, 6 and 7, but 3dsmax 5 dont have physique, and 3dsmax 6 don't run on Windows 7, so, i recommend the 3dsmax 7, just to export the armor ase's.

In my case, even with the 3dsmax7, the exporter was giving me a hard time (was giving me a error message about the ase exporter). I could use the ase exporter only after installing the "MSVC++ 2005" and 'repairing' the 3dsmax7 (with the installation executable)..

You can also download a 'dll dependency walker' to check which files are missing for the exporter to work, but this can be very tricky (for each missing file you download, it would require another 15 to work (EVERY TIME D= ) and if you eventually download them ALL, the 3ds just crash (wont even open XD).


Well, here we go =D


Char/TMABCD directory - On this folder are all 'clothes' the characters actually 'wear'.


TM = Tempskron and Morion
ABCD = Characters:
A - Mechanician
B - Fighter
C - Pikeman
D - Archer

mA - Knight
mB - Atalanta
mC - Priestess
mD - Magician


*.inx - Coded filer for the armor (tells the game which files are the model (and, on these files, the exact name of the meshes) and animation files).
*.smd - 3d model.
*.smb - Animation coordinates for smd.
*.ini - Human language inx.
*.ase - Human language smd.
*.bmp - Bitmap , Image file (texture)
*.tga - Truevision Graphics Adapter , Image file (texture). Regarding pt, an alpha channel can be used on TGA's to apply selective opacity.



Image/Sinimage/Items directory:

DropItem and Defense subdirectories - On this folder are every item you would see dropped (on the ground, the DropItem, this includes armors and items you would only see on the ground or inventory (rings, etc..)) and the inventory images (shields, boots, bracelets, gauntlets and armors, on the Defense subdirectory). Bracelet's inventory images are on the Accessory subdirectory.

Defense/DropItem folder item names:

"IT" = "item"
"D" = "Defense"
"A" = "Armor"
"B" = "Boots"
"G" = "Gauntlets/Gloves"
"S" = "Shield"
"OA2"= "Bracelets (on 'Accessory' subdirectory)


Armor files:

(On char/TMABDC):
ini/inx = Describing .ase name, its mesh names and the related smb (animation) file.
ase = Your armor model.
tga/bmp = Your armor texture (also called 'skin files').
smb = Animation file (dont need to mess with it)

(On Image/Sinimage/Items):
ase = Drop ('on the ground') version of armor / boots / gauntlets and bracelets. (on DropItem folder).
tga/bmp = Drop version texture files (on DropItem folder).
BMP (66x88p) = Inventory image of the armor, boots and gauntlets (on Defense folder).
BMP (44x44p) = Inventory image of bracelets (on Accessory folder).


Making/editing the armor:

The way i did it was editing some functional ase's found on my server. These are the ase's found for the characters:


tmbA14_p.ase - Mechanician (A)
tmbB14_p.ase - Fighter (B)
TmbC14_p.ase - Pikeman (C)
tfbD14_p.ase - Archer (D)

MmbA16.ase - Knight (mA)
MfbB18_p.ase - Atalanta (mB)
MfbC11_p.ase - Priestess (mC)
MmbD11_p.ase - Magician (mD)

If you dont have these files, you can download them here

On tmbA14 :
t = Tempskron
m = Male
b = Body (there are some with 'h', for hair)
A = Letter for mech/knight.

On MfbB18 :
M = Morion
f = Female
b = Body (there are some with 'h', for hair)
B = Letter for Atalanta/Fighter.


Personally i do not know how to add an new armor without replacing other, but here we worry about making the armor work, lets worry about adding it (on the client and server executables) afterwards =D (i suppose there are already some good guides on this particular subject)...


-Log in the game with an admin account and press F9 to see the inx your character is wearing:

15r1mis.jpg

-Open this ini (inx) on Notepad or other text editor (like MadEdit), and write down the mesh names, it will be something like this (different on inx, but with the same information):

// 캐릭터 주인공 설정값


*모양파일----- tmbA14_p.ASE

*정밀모양----- "TAHA19" -arms (Probably 'Gauntlets/Gloves' in Vormav's Mod)
*정밀모양----- "TBHA19" -body (Probably 'Armor' in Vormav's Mod)
*정밀모양----- "TLHA19" -legs (Probably 'Boots' in Vormav's Mod)
*정밀모양----- "TSHA19" -shoulder pads (Probably 'bracelets' in Vormav's Mod)

*보통모양----- "TAHA19" (could be TAMA19 in some cases (medium res))
*보통모양----- "TBHA19"
*보통모양----- "TLHA19"
*보통모양----- "TSHA19"

*저질모양----- "TAHA19" (could be TALA19 in some cases (low res))
*저질모양----- "TBHA19"
*저질모양----- "TLHA19"
*저질모양----- "TSHA19"


*파일연결----- M1Bip.in (the in* for bones and animation)

(Babylon translation):

캐릭터 주인공 설정값 - "The hero character set"
모양파일 - "File appearance" (the model filename)
정밀모양 - "Aspect/precision/exactness" (probably the high res meshes)
보통모양 - "Usually, generally, regularly" (probably the medium res meshes)
저질모양 "Potter's clay, book wrapper, quality" (probably the low res meshes)
(or "to lose, yield, bear, fall, set, sink
come off, shade, become, lose out, droop, take")
파일연결 - "File connection"


The meshes on the armor you would make shall have the same name of the meshes described on the in* file. Here is some explanation on how you should name the meshes:


On TAHA19 (example):

T = Tempskron (would be M if it were an morion mesh).
A = Arms, it could be "B" for body, "S" for shoulder(pads), "L" for legs (and boots).
H = High resolution, most armors have just meshes for high res (it could be 'L' for low and 'M' for medium res).
A = Letter for Mechanician (would be B for fighter, C for pike, or D for archer).
19 = Because it is the 19th armor (armor parts set).


For an example, if i would make an shoulder pad for the wyvern armor on Atalanta, the name of its mesh should be MSHB19 (Morion-Shoulder-High.Res-"B"Atalanta-On armor no.19)



-Open the 3dsmax (i recommend 3dsmax 7, just for exporting the ase with the Sandurr exporter)
-Obviously, make the armor (part(s)) you want your character to wear (tip "Think low-poly" XD)
-Save this armor (or armor part) or export it to 3ds (you can also make the parts on a higher version of 3dsMax, and export them (on .3ds) to the 3dsMax7, in this case, save the UVW's).
-Import one of the mentioned character ase's , and 'fix' your armor part(s) on the char body (re-position and scale the part(s))
-Rig it with the Physique, on this stage, all armor parts i've made i actually exported each one ("Export Selected") to an individual ase (one ase just for arms, one just for shoulder pads..), i thought it would be easier or better organized.
-Physique is a 3dsMax modifier featured on 3dsmax 6 or above. To rig an mesh with Physique, access the modifiers, scroll down the list and click on Physique, then, click on the "Attach to node" button (24e0ze1.jpg).
-Use these parameters (Pt does not support blending between links):
8x6lpg.jpg
-It would look like this:
atkznq.jpg
-Go to the modifiers list - Physique - Vertex:
2zgryhe.jpg
-Check 'No Blending' and click "Select" (you will select the vertexes).
oktxyc.jpg
-And then click "Assign to Link" (these yellow lines are the links...) in this case, i will assign it to the forearm (some characters have specific bones for shoulder pads...)
2ypekpj.jpg
-These shoulder pads are the easiest (and the arms are a bit more difficult) to rig. Basically you would select and assign the vertexes to the proper links. (you wouldn't link an leg vertex to a head link, correct? XD)
-All vertexes need to be properly linked, or some bizarre stretching can occur (ex: Atalanta's official Frenzy armor, with the stretched arm backside (on the offense(weapon) arm).
-Test the rig (conection between vertexes and links) by rotating the rigged bone (in this particular case, the forearm..).
-Now select just the part you made, and export it (export selected).
faugja.jpg
-You can close the 3ds if you want now (save individual rigged parts XD)
-Open one of those (functional) character ase's i've mentioned on MadEdit or Notepad (notepad will be extremely laggy)
-And open your armor (or armor piece) ase on another tab/window.
-You will need the information on the in* (ini or inx) file too, to know the exact proper name of the meshes.
-Find the armor part you want to replace for yours (in this case, its the MSHB, so i searched for it). In the case of a full new armor, obviously you would replace all xd..

-On the 'ase language' , the geometric objets are called "GEOMOBJECT".. In this particular case, i need to find the MSHB mesh.
4zyoom.jpg
-Since i exported all the parts individually, its easy to find the mesh on the export (its just one XD).. So i copy and paste these parts (REPLACING ON THE ORIGINAL), one by one, and respecting the original (functional) ase syntax (there are small differences on the syntax):

*MESH_VERTEX_LIST { ... }
(XYZ vertex coordinates)

*MESH_FACE_LIST { ... }
(Facial boundaries, smoothing and Material ID)

*MESH_NUMTVERTEX 'X'
*MESH_TVERTLIST {...}
*MESH_NUMTVFACES 'X'
*MESH_TFACELIST {...}
(Texture coordinates)

*PHYSIQUE {...}
(Bone to vertex linking)

-The "*MATERIAL_REF" is the material (on the beggining of the ase file) of this particular mesh, if it uses an specific sub-material, you need to change the '*MESH_MTL ID' on the '*MESH_FACE_LIST'.


-For the texture and effecting, change the '*Material_List'. Add a new material (or change the original to your texture). This part (texture (MATERIAL)) is very simple to understand =D

-Check again the in* file (and your new/altered ase), to see if you wrote the mesh names correctly (wrongly named meshes will just be invisible, improper bones will crash the game ("will give a game.exe")). Check the correct ase name as well (ase/smd which the in* will request) .
-If you edit (for the first time) with this method (with the mentioned ase's), you can (should indeed) delete the parts you will not use.
-Test it :
2woydu8.jpg
(just the shoulder pads, with "reflex" effect (..its another model..), as noticed on this image, you can have multiple meshes for armor parts, you need only to give both meshes the same name (in this case, MSHBXX)
2lsa0lv.jpg
(the actual arm and shoulder pad from the example images)


-Basically you would replace the original meshes (on the functional ase's) to your own armor parts :)




Well, for now, thats it :)


Hope it helps somebody, thanks a lot of people especially Vormav, Bobsobol and Sungam3d =D

And SheenBr for empowering my will of doing this 'guide' and for telling me about the MadEdit.
Last edited: Oct 25, 2011
```