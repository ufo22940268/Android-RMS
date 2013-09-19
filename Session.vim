let SessionLoad = 1
if &cp | set nocp | endif
let s:cpo_save=&cpo
set cpo&vim
inoremap <silent> <S-Tab> =BackwardsSnippet()
inoremap <C-Tab> 	
inoremap <Plug>(EmmetAnchorizeSummary) =emmet#anchorizeURL(1)
inoremap <Plug>(EmmetAnchorizeURL) =emmet#anchorizeURL(0)
inoremap <Plug>(EmmetRemoveTag) =emmet#removeTag()
inoremap <Plug>(EmmetSplitJoinTag) :call emmet#splitJoinTag()
inoremap <Plug>(EmmetToggleComment) =emmet#toggleComment()
inoremap <Plug>(EmmetImageSize) =emmet#imageSize()
inoremap <Plug>(EmmetMovePrev) :call emmet#moveNextPrev(1)
inoremap <Plug>(EmmetMoveNext) :call emmet#moveNextPrev(0)
inoremap <Plug>(EmmetBalanceTagOutward) :call emmet#balanceTag(-1)
inoremap <Plug>(EmmetBalanceTagInward) :call emmet#balanceTag(1)
inoremap <Plug>(EmmetExpandWord) =emmet#expandAbbr(1,"")
inoremap <Plug>(EmmetExpandAbbr) =emmet#expandAbbr(0,"")<Right>
inoremap <silent> <Plug>NERDCommenterInsert  <BS>:call NERDComment('i', "insert")
snoremap <silent> 	 i<Right>=TriggerSnippet()
vmap <NL> <Plug>MoveBlockDown
vmap  <Plug>MoveBlockUp
noremap  :TagbarToggle
xnoremap <silent>  :call multiple_cursors#new("v")
nnoremap <silent>  :call multiple_cursors#new("n")
nnoremap <silent>  :CtrlP
map  :WMToggle
snoremap  b<BS>
vmap c <Plug>(EmmetCodePretty)
vmap m <Plug>(EmmetMergeLines)
nmap A <Plug>(EmmetAnchorizeSummary)
nmap a <Plug>(EmmetAnchorizeURL)
nmap k <Plug>(EmmetRemoveTag)
nmap j <Plug>(EmmetSplitJoinTag)
nmap / <Plug>(EmmetToggleComment)
nmap i <Plug>(EmmetImageSize)
nmap N <Plug>(EmmetMovePrev)
nmap n <Plug>(EmmetMoveNext)
vmap D <Plug>(EmmetBalanceTagOutward)
nmap D <Plug>(EmmetBalanceTagOutward)
vmap d <Plug>(EmmetBalanceTagInward)
nmap d <Plug>(EmmetBalanceTagInward)
nmap ; <Plug>(EmmetExpandWord)
vmap , <Plug>(EmmetExpandAbbr)
nmap , <Plug>(EmmetExpandAbbr)
map   /
vnoremap $/ `>a*/`<i/*
vnoremap $< `>a -->`<i<!-- 
vnoremap $w `>a"`<i"
vnoremap $q `>a'`<i'
vnoremap $$ `>a"`<i"
vnoremap $3 `>a}`<i{
vnoremap $2 `>a]`<i[
vnoremap $1 `>a)`<i(
snoremap % b<BS>%
snoremap ' b<BS>'
nmap <silent> ,cv <Plug>VCSVimDiff
nmap <silent> ,cU <Plug>VCSUnlock
nmap <silent> ,cr <Plug>VCSReview
nmap <silent> ,cq <Plug>VCSRevert
nmap <silent> ,cN <Plug>VCSSplitAnnotate
nmap <silent> ,cL <Plug>VCSLock
nmap <silent> ,cg <Plug>VCSGotoOriginal
nmap <silent> ,cG <Plug>VCSClearAndGotoOriginal
nmap <silent> ,cD <Plug>VCSDelete
nnoremap <silent> ,b :CommandTBuffer
nnoremap <silent> ,t :CommandT
nmap ,caL <Plug>CalendarH
nmap ,cal <Plug>CalendarV
nmap ,scp <Plug>SQLUCreateProcedure
nmap ,scdt <Plug>SQLUGetColumnDataType
nmap ,scd <Plug>SQLUGetColumnDef
nmap ,scl <Plug>SQLUCreateColumnList
vmap ,sf <Plug>SQLUFormatter
nmap ,sf <Plug>SQLUFormatter
vmap ,sfs <Plug>SQLUFormatter
nmap ,sfs <Plug>SQLUFormatter
vmap ,sfr <Plug>SQLUFormatStmts
nmap ,sfr <Plug>SQLUFormatStmts
noremap ,fm :call OpenMakeFileSelector()
nmap <silent> ,ig <Plug>IndentGuidesToggle
nmap ,ca <Plug>NERDCommenterAltDelims
xmap ,cu <Plug>NERDCommenterUncomment
nmap ,cu <Plug>NERDCommenterUncomment
xmap ,cb <Plug>NERDCommenterAlignBoth
nmap ,cb <Plug>NERDCommenterAlignBoth
xmap ,cl <Plug>NERDCommenterAlignLeft
nmap ,cl <Plug>NERDCommenterAlignLeft
nmap ,cA <Plug>NERDCommenterAppend
xmap ,cy <Plug>NERDCommenterYank
nmap ,cy <Plug>NERDCommenterYank
xmap ,cs <Plug>NERDCommenterSexy
nmap ,cs <Plug>NERDCommenterSexy
xmap ,ci <Plug>NERDCommenterInvert
nmap ,ci <Plug>NERDCommenterInvert
nmap ,c$ <Plug>NERDCommenterToEOL
xmap ,cn <Plug>NERDCommenterNested
nmap ,cn <Plug>NERDCommenterNested
xmap ,cm <Plug>NERDCommenterMinimal
nmap ,cm <Plug>NERDCommenterMinimal
xmap ,c  <Plug>NERDCommenterToggle
nmap ,c  <Plug>NERDCommenterToggle
xmap ,cc <Plug>NERDCommenterComment
nmap ,cc <Plug>NERDCommenterComment
nnoremap ,fU :execute 'CtrlPFunky ' . expand('<cword>')
nnoremap ,fu :CtrlPFunky
noremap ,vl :cla
nnoremap ,va :e ~/.config/awesome/rc.lua
nnoremap ,vt :exec "e ~/.vim/bundle/vim-template/templates/template.".&filetype
nnoremap ,vn :call EditSnippet()
nnoremap ,vi ?^import
nnoremap ,vh gg/class
nnoremap ,vu :!ant uninstall
nnoremap ,vd :!mvn android:deploy
nnoremap ,vac :!make clean
nnoremap ,vr :make runa
nnoremap ,vf :let @f=expand("%:t:r")
map ,pt :set invpaste
noremap ,fb viB:g!#^.*//#Tabularize /,
noremap ,u hgUiwe
noremap ,tcd :call ClearDb()
noremap ,pl :call PushLarge()
noremap ,py :call PushYlzhao()
vnoremap ,cp :call CopySelectionLines()
vnoremap ,p :call EchoSelectionLines()
noremap ,m :Make
noremap ,cd :call CdToProjectRoot()
map ,wp :call SwitchToProject("PROVIDER")
map ,wr :call SwitchToProject("RES")
map ,wf :call SwitchToProject("FRA")
map ,wh :call SwitchToProject("CALL_HISTORY")
map ,wc :call SwitchToProject("CONTACTS")
map <silent> ,bt :!ctags -R --exclude=\.* 
noremap ,vcg :e =language_dir/zh.txt
noremap ,veg :e =language_dir/en.txt
noremap ,vcs :e res/values-zh-rCN/strings.xml
noremap ,ves :e res/values/strings.xml
noremap ,do :call DebugOuterClass()
noremap ,di :call DebugInnerClass()
noremap ,tc :!adb_connect
noremap ,tr :!adb shell stop; sleep 2; adb shell start
map ,z <Plug>ZoomWin
noremap <silent> ,bc :!find . -name *.java > cscope.files && cscope -b -q
noremap ,ts :!target_sync
map ,vs :so ~/.vimrc
map ,vv :e ~/.vimrc
noremap ,vp :let @p=expand("%:p")
map ,ac :!adb_connect && pactive $TARGET
map ,al :!adb_connect&&adb logcat
map ,vxs :sp ~/.vim/snippets/xml.snippets
map ,vjs :sp ~/.vim/snippets/java.snippets
nmap ,rr :call ReloadSnippets(snippets_dir, &filetype)
nmap ,et :exec "e ~/.vim/ftplugin/".&filetype.".vim"
nmap ,es :call EditSnippet()
map ,y :YRShow
map ,s? z=
map ,sa zg
map ,sp [
map ,sn ]
nmap ,w :w!
nmap ,x :xa!
map 0 ^
cnoremap √® 
cnoremap √§ <S-Right>
cmap √¶ <S-Right>
cmap √¢ <S-Left>
snoremap U b<BS>U
vmap [% [%m'gv``
snoremap \ b<BS>\
vmap ]% ]%m'gv``
snoremap ^ b<BS>^
snoremap ` b<BS>`
vmap a% [%v]%
onoremap <silent> aC :call TextObjWordBasedColumn("aW")
onoremap <silent> ac :call TextObjWordBasedColumn("aw")
xnoremap <silent> aC :call TextObjWordBasedColumn("aW")
xnoremap <silent> ac :call TextObjWordBasedColumn("aw")
nmap gx <Plug>NetrwBrowseX
onoremap <silent> iC :call TextObjWordBasedColumn("iW")
onoremap <silent> ic :call TextObjWordBasedColumn("iw")
xnoremap <silent> iC :call TextObjWordBasedColumn("iW")
xnoremap <silent> ic :call TextObjWordBasedColumn("iw")
nnoremap <silent> <Plug>(n) :call multiple_cursors#new('v')
nnoremap <silent> <Plug>(s) :call multiple_cursors#skip()
nnoremap <silent> <Plug>(p) :call multiple_cursors#prev()
snoremap <Left> bi
snoremap <Right> a
snoremap <BS> b<BS>
snoremap <silent> <S-Tab> i<Right>=BackwardsSnippet()
nnoremap <silent> <Plug>NetrwBrowseX :call netrw#NetrwBrowseX(expand("<cWORD>"),0)
nnoremap <silent> <Plug>CVSWatchRemove :CVSWatch remove
nnoremap <silent> <Plug>CVSWatchOn :CVSWatch on
nnoremap <silent> <Plug>CVSWatchOff :CVSWatch off
nnoremap <silent> <Plug>CVSWatchAdd :CVSWatch add
nnoremap <silent> <Plug>CVSWatchers :CVSWatchers
nnoremap <silent> <Plug>CVSUnedit :CVSUnedit
nnoremap <silent> <Plug>CVSEditors :CVSEditors
nnoremap <silent> <Plug>CVSEdit :CVSEdit
nnoremap <silent> <Plug>VCSVimDiff :VCSVimDiff
nnoremap <silent> <Plug>VCSUpdate :VCSUpdate
nnoremap <silent> <Plug>VCSUnlock :VCSUnlock
nnoremap <silent> <Plug>VCSStatus :VCSStatus
nnoremap <silent> <Plug>VCSSplitAnnotate :VCSAnnotate!
nnoremap <silent> <Plug>VCSReview :VCSReview
nnoremap <silent> <Plug>VCSRevert :VCSRevert
nnoremap <silent> <Plug>VCSLog :VCSLog
nnoremap <silent> <Plug>VCSLock :VCSLock
nnoremap <silent> <Plug>VCSInfo :VCSInfo
nnoremap <silent> <Plug>VCSClearAndGotoOriginal :VCSGotoOriginal!
nnoremap <silent> <Plug>VCSGotoOriginal :VCSGotoOriginal
nnoremap <silent> <Plug>VCSDiff :VCSDiff
nnoremap <silent> <Plug>VCSDelete :VCSDelete
nnoremap <silent> <Plug>VCSCommit :VCSCommit
nnoremap <silent> <Plug>VCSAnnotate :VCSAnnotate
nnoremap <silent> <Plug>VCSAdd :VCSAdd
nnoremap <silent> <Plug>CalendarH :cal Calendar(1)
nnoremap <silent> <Plug>CalendarV :cal Calendar(0)
vnoremap <Plug>(EmmetCodePretty) :call emmet#codePretty()
vnoremap <Plug>(EmmetMergeLines) :call emmet#mergeLines()
nnoremap <Plug>(EmmetAnchorizeSummary) :call emmet#anchorizeURL(1)
nnoremap <Plug>(EmmetAnchorizeURL) :call emmet#anchorizeURL(0)
nnoremap <Plug>(EmmetRemoveTag) :call emmet#removeTag()
nnoremap <Plug>(EmmetSplitJoinTag) :call emmet#splitJoinTag()
nnoremap <Plug>(EmmetToggleComment) :call emmet#toggleComment()
nnoremap <Plug>(EmmetImageSize) :call emmet#imageSize()
nnoremap <Plug>(EmmetMovePrev) :call emmet#moveNextPrev(1)
nnoremap <Plug>(EmmetMoveNext) :call emmet#moveNextPrev(0)
vnoremap <Plug>(EmmetBalanceTagOutward) :call emmet#balanceTag(-2)
nnoremap <Plug>(EmmetBalanceTagOutward) :call emmet#balanceTag(-1)
vnoremap <Plug>(EmmetBalanceTagInward) :call emmet#balanceTag(2)
nnoremap <Plug>(EmmetBalanceTagInward) :call emmet#balanceTag(1)
nnoremap <Plug>(EmmetExpandWord) :call emmet#expandAbbr(1,"")
vnoremap <Plug>(EmmetExpandAbbr) :call emmet#expandAbbr(2,"")
nnoremap <Plug>(EmmetExpandAbbr) :call emmet#expandAbbr(3,"")
xnoremap <silent> <Plug>NERDCommenterUncomment :call NERDComment("x", "Uncomment")
nnoremap <silent> <Plug>NERDCommenterUncomment :call NERDComment("n", "Uncomment")
xnoremap <silent> <Plug>NERDCommenterAlignBoth :call NERDComment("x", "AlignBoth")
nnoremap <silent> <Plug>NERDCommenterAlignBoth :call NERDComment("n", "AlignBoth")
xnoremap <silent> <Plug>NERDCommenterAlignLeft :call NERDComment("x", "AlignLeft")
nnoremap <silent> <Plug>NERDCommenterAlignLeft :call NERDComment("n", "AlignLeft")
nnoremap <silent> <Plug>NERDCommenterAppend :call NERDComment("n", "Append")
xnoremap <silent> <Plug>NERDCommenterYank :call NERDComment("x", "Yank")
nnoremap <silent> <Plug>NERDCommenterYank :call NERDComment("n", "Yank")
xnoremap <silent> <Plug>NERDCommenterSexy :call NERDComment("x", "Sexy")
nnoremap <silent> <Plug>NERDCommenterSexy :call NERDComment("n", "Sexy")
xnoremap <silent> <Plug>NERDCommenterInvert :call NERDComment("x", "Invert")
nnoremap <silent> <Plug>NERDCommenterInvert :call NERDComment("n", "Invert")
nnoremap <silent> <Plug>NERDCommenterToEOL :call NERDComment("n", "ToEOL")
xnoremap <silent> <Plug>NERDCommenterNested :call NERDComment("x", "Nested")
nnoremap <silent> <Plug>NERDCommenterNested :call NERDComment("n", "Nested")
xnoremap <silent> <Plug>NERDCommenterMinimal :call NERDComment("x", "Minimal")
nnoremap <silent> <Plug>NERDCommenterMinimal :call NERDComment("n", "Minimal")
xnoremap <silent> <Plug>NERDCommenterToggle :call NERDComment("x", "Toggle")
nnoremap <silent> <Plug>NERDCommenterToggle :call NERDComment("n", "Toggle")
xnoremap <silent> <Plug>NERDCommenterComment :call NERDComment("x", "Comment")
nnoremap <silent> <Plug>NERDCommenterComment :call NERDComment("n", "Comment")
map <F9> ggVGg?
xmap <BS> "-d
cmap  <Home>
cmap  <Left>
cnoremap  <Del>
cmap  <End>
cmap  <Right>
cnoremap  <BS>
inoremap <silent> 	 =TriggerSnippet()
cnoremap  
imap  <Plug>SuperTabForward
cmap  <Down>
imap  <Plug>SuperTabBackward
cmap  <Up>
inoremap <silent> 	 =ShowAvailableSnips()
imap A <Plug>(EmmetAnchorizeSummary)
imap a <Plug>(EmmetAnchorizeURL)
imap k <Plug>(EmmetRemoveTag)
imap j <Plug>(EmmetSplitJoinTag)
imap / <Plug>(EmmetToggleComment)
imap i <Plug>(EmmetImageSize)
imap N <Plug>(EmmetMovePrev)
imap n <Plug>(EmmetMoveNext)
imap D <Plug>(EmmetBalanceTagOutward)
imap d <Plug>(EmmetBalanceTagInward)
imap ; <Plug>(EmmetExpandWord)
imap , <Plug>(EmmetExpandAbbr)
vmap √´ :m'<-2`>my`<mzgv`yo`z
vmap √™ :m'>+`<my`>mzgv`yo`z
nmap √´ <Plug>MoveLineDown
nmap √™ <Plug>MoveLineDown
cabbr rename =getcmdpos() == 1 && getcmdtype() == ":" ? "Rename" : "rename"
cabbr <expr> %$ expand('%:t:r')
cabbr <expr> %% expand('%:h')
iabbr xdate =strftime("%d/%m/%y %H:%M:%S")
let &cpo=s:cpo_save
unlet s:cpo_save
set autoindent
set autoread
set autowrite
set background=dark
set backspace=2
set balloonexpr=JavaBrowser_Show_Prototype()
set cindent
set cmdheight=2
set errorfile=/var/folders/t6/rs4ks2815_v70py8ppjpfn9w0000gn/T/v2RYdrE/109
set errorformat=[ERROR]\ %f:[%l\\,%v]\ %m
set expandtab
set fileencodings=ucs-bom,utf-8,cp936,big5,euc-jp,euc-kr,latin1
set guitablabel=%{TabGuiCaptionLabel()}
set helplang=en
set hidden
set ignorecase
set incsearch
set keywordprg=man
set langmenu=none
set laststatus=2
set matchtime=8
set mouse=a
set path=.,/usr/include,,,res/layout,res/layout-finger,res/values,res/drawable,res/drawable-mdpi,res/drawable-hdpi,res/menu,assets,js,css,img
set ruler
set runtimepath=~/.vim/bundle/vundle,~/.vim/bundle/vim-fugitive,~/.vim/bundle/Conque-Shell,~/.vim/bundle/tabular,~/.vim/bundle/nerdcommenter,~/.vim/bundle/vim-java-get-set,~/.vim/bundle/emmet-vim,~/.vim/bundle/textobj-word-column.vim,~/.vim/bundle/renamer.vim,~/.vim/bundle/rename.vim,~/.vim/bundle/tagbar,~/.vim/bundle/vim-indent-guides,~/.vim/bundle/gist-vim,~/.vim/bundle/webapi-vim,~/.vim/bundle/vim-move,~/.vim/bundle/vim-colors-solarized,~/.vim/bundle/lightline.vim,~/.vim/bundle/ctrlp.vim,~/.vim/bundle/ctrlp-funky,~/.vim/bundle/vim-multiple-cursors,~/.vim/bundle/vim-make-selector,~/.vim/bundle/vim-dispatch,~/.vim/bundle/vim-template,~/.vim,/usr/local/Cellar/macvim/7.3-64/MacVim.app/Contents/Resources/vim/vimfiles,/usr/local/Cellar/macvim/7.3-64/MacVim.app/Contents/Resources/vim/runtime,/usr/local/Cellar/macvim/7.3-64/MacVim.app/Contents/Resources/vim/vimfiles/after,~/.vim/after,~/.vim/bundle/vundle/,~/.vim/bundle/vundle/after,~/.vim/bundle/vim-fugitive/after,~/.vim/bundle/Conque-Shell/after,~/.vim/bundle/tabular/after,~/.
set scrolloff=7
set sessionoptions=options
set shell=bash\ -l
set shiftwidth=4
set showmatch
set smartcase
set smartindent
set smarttab
set softtabstop=4
set statusline=%02n:%<%f\ %h%m%r%=%-14.(%l,%c%V%)\ %P
set suffixes=.bak,~,.o,.h,.info,.swp,.obj,.class
set suffixesadd=.java,.xml,.9.png,.png,.py,.xml,.png,.9.png
set noswapfile
set tabline=%!TabCaptionLineFunction()
set tabstop=4
set termencoding=utf-8
set visualbell
set wildmenu
set nowritebackup
let s:so_save = &so | let s:siso_save = &siso | set so=0 siso=0
let v:this_session=expand("<sfile>:p")
silent only
if expand('%') == '' && !&modified && line('$') <= 1 && getline(1) == ''
  let s:wipebuf = bufnr('%')
endif
set shortmess=aoO
badd +31 ~/workspace/rms/src/me/biubiubiu/rms/RepoManageFragment.java
badd +7 ~/workspace/rms/res/layout/repo_manage_fragment.xml
badd +0 ~/workspace/rms/res/layout/row_repo_manage.xml
badd +5 ~/workspace/rms/res/layout/row_item_repo_manage.xml
silent! argdel *
edit ~/workspace/rms/src/me/biubiubiu/rms/RepoManageFragment.java
set splitbelow splitright
wincmd _ | wincmd |
vsplit
1wincmd h
wincmd w
wincmd _ | wincmd |
split
wincmd _ | wincmd |
split
2wincmd k
wincmd w
wincmd w
set nosplitbelow
set nosplitright
wincmd t
set winheight=1 winwidth=1
wincmd =
argglobal
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal balloonexpr=
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=j1
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=sO:*\ -,mO:*\ \ ,exO:*/,s1:/*,mb:*,ex:*/,://,b:#,:%,:XCOMM,n:>,fb:-
setlocal commentstring=//%s
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=
setlocal expandtab
if &filetype != 'java'
setlocal filetype=java
endif
setlocal foldcolumn=0
setlocal foldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=manual
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=2
setlocal imsearch=2
setlocal include=
setlocal includeexpr=substitute(v:fname,'\\.','/','g')
setlocal indentexpr=GetJavaIndent_improved()
setlocal indentkeys=0{,0},:,0#,!^F,o,O,e,0=extends,0=implements
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
set linebreak
setlocal linebreak
setlocal nolisp
setlocal nolist
setlocal nomacmeta
setlocal makeprg=
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=%{lightline#link()}%#LightLineLeft_active_0#%(\ %{lightline#function(\"MyMode\")}\ %)%{(!!strlen(lightline#function(\"MyMode\")))*(((&paste)))?('‚ÆÅ'):''}%(\ %{&paste?\"PASTE\":\"\"}\ %)%#LightLineLeft_active_0_1#‚ÆÄ%#LightLineLeft_active_1#%(\ %{lightline#function(\"MyFugitive\")}\ %)%{(!!strlen(lightline#function(\"MyFugitive\")))*((!!strlen(lightline#function(\"MyFilename\"))))?('‚ÆÅ'):''}%(\ %{lightline#function(\"MyFilename\")}\ %)%#LightLineLeft_active_1_2#‚ÆÄ%#LightLineMiddle_active#%=%#LightLineRight_active_2_3#‚ÆÇ%#LightLineRight_active_2#%(\ %{lightline#function(\"MyFileformat\")}\ %)%{(!!strlen(lightline#function(\"MyFileencoding\")))*((!!strlen(lightline#function(\"MyFileformat\"))))?('‚ÆÉ'):''}%(\ %{lightline#function(\"MyFileencoding\")}\ %)%{(!!strlen(lightline#function(\"MyFiletype\")))*((!!strlen(lightline#function(\"MyFileformat\")))+(!!strlen(lightline#function(\"MyFileencoding\"))))?('‚ÆÉ'):''}%(\ %{lightline#function(\"MyFiletype\")}\ %)%#LightLineRight_active_1_2#‚ÆÇ%#LightLineRight_active_1#%(\ %3p%%\ %)%#LightLineRight_active_0_1#‚ÆÇ%#LightLineRight_active_0#%(\ %3l:%-2v\ %)
setlocal suffixesadd=.java,.xml,.9.png,.png,.py,.xml,.png,.9.png
setlocal noswapfile
setlocal synmaxcol=3000
if &syntax != 'java'
setlocal syntax=java
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 36 - ((23 * winheight(0) + 16) / 32)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
36
normal! 0
wincmd w
argglobal
edit ~/workspace/rms/res/layout/repo_manage_fragment.xml
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal balloonexpr=
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=s:<!--,m:\ \ \ \ \ ,e:-->
setlocal commentstring=<!--%s-->
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=
setlocal expandtab
if &filetype != 'xml'
setlocal filetype=xml
endif
setlocal foldcolumn=0
setlocal nofoldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=indent
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=2
setlocal imsearch=2
setlocal include=
setlocal includeexpr=
setlocal indentexpr=XmlIndentGet(v:lnum,1)
setlocal indentkeys=o,O,*<Return>,<>>,<<>,/,{,}
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
set linebreak
setlocal linebreak
setlocal nolisp
setlocal nolist
setlocal nomacmeta
setlocal makeprg=
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=xmlcomplete#CompleteTags
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=%{lightline#link()}%#LightLineLeft_inactive_0#%(\ %{lightline#function(\"MyFilename\")}\ %)%#LightLineLeft_inactive_0_1#‚ÆÄ%#LightLineMiddle_inactive#%=%#LightLineRight_inactive_1_2#‚ÆÇ%#LightLineRight_inactive_1#%(\ %3p%%\ %)%#LightLineRight_inactive_0_1#‚ÆÇ%#LightLineRight_inactive_0#%(\ %3l:%-2v\ %)
setlocal suffixesadd=.java,.xml,.9.png,.png,.py,.xml,.png,.9.png
setlocal noswapfile
setlocal synmaxcol=3000
if &syntax != 'xml'
setlocal syntax=xml
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 4 - ((3 * winheight(0) + 4) / 8)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
4
normal! 0
wincmd w
argglobal
edit ~/workspace/rms/res/layout/row_item_repo_manage.xml
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal balloonexpr=
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=s:<!--,m:\ \ \ \ \ ,e:-->
setlocal commentstring=<!--%s-->
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=
setlocal expandtab
if &filetype != 'xml'
setlocal filetype=xml
endif
setlocal foldcolumn=0
setlocal nofoldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=indent
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=2
setlocal imsearch=2
setlocal include=
setlocal includeexpr=
setlocal indentexpr=XmlIndentGet(v:lnum,1)
setlocal indentkeys=o,O,*<Return>,<>>,<<>,/,{,}
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
set linebreak
setlocal linebreak
setlocal nolisp
setlocal nolist
setlocal nomacmeta
setlocal makeprg=
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=xmlcomplete#CompleteTags
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=%{lightline#link()}%#LightLineLeft_inactive_0#%(\ %{lightline#function(\"MyFilename\")}\ %)%#LightLineLeft_inactive_0_1#‚ÆÄ%#LightLineMiddle_inactive#%=%#LightLineRight_inactive_1_2#‚ÆÇ%#LightLineRight_inactive_1#%(\ %3p%%\ %)%#LightLineRight_inactive_0_1#‚ÆÇ%#LightLineRight_inactive_0#%(\ %3l:%-2v\ %)
setlocal suffixesadd=.java,.xml,.9.png,.png,.py,.xml,.png,.9.png
setlocal noswapfile
setlocal synmaxcol=3000
if &syntax != 'xml'
setlocal syntax=xml
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal nowinfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 5 - ((1 * winheight(0) + 3) / 7)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
5
normal! 0
wincmd w
argglobal
edit ~/workspace/rms/res/layout/row_repo_manage.xml
setlocal keymap=
setlocal noarabic
setlocal autoindent
setlocal balloonexpr=
setlocal nobinary
setlocal bufhidden=
setlocal buflisted
setlocal buftype=
setlocal cindent
setlocal cinkeys=0{,0},0),:,0#,!^F,o,O,e
setlocal cinoptions=
setlocal cinwords=if,else,while,do,for,switch
setlocal colorcolumn=
setlocal comments=s:<!--,m:\ \ \ \ \ ,e:-->
setlocal commentstring=<!--%s-->
setlocal complete=.,w,b,u,t,i
setlocal concealcursor=
setlocal conceallevel=0
setlocal completefunc=
setlocal nocopyindent
setlocal cryptmethod=
setlocal nocursorbind
setlocal nocursorcolumn
setlocal nocursorline
setlocal define=
setlocal dictionary=
setlocal nodiff
setlocal equalprg=
setlocal errorformat=
setlocal expandtab
if &filetype != 'xml'
setlocal filetype=xml
endif
setlocal foldcolumn=0
setlocal nofoldenable
setlocal foldexpr=0
setlocal foldignore=#
setlocal foldlevel=0
setlocal foldmarker={{{,}}}
setlocal foldmethod=indent
setlocal foldminlines=1
setlocal foldnestmax=20
setlocal foldtext=foldtext()
setlocal formatexpr=
setlocal formatoptions=croql
setlocal formatlistpat=^\\s*\\d\\+[\\]:.)}\\t\ ]\\s*
setlocal grepprg=
setlocal iminsert=2
setlocal imsearch=2
setlocal include=
setlocal includeexpr=
setlocal indentexpr=XmlIndentGet(v:lnum,1)
setlocal indentkeys=o,O,*<Return>,<>>,<<>,/,{,}
setlocal noinfercase
setlocal iskeyword=@,48-57,_,192-255
setlocal keywordprg=
set linebreak
setlocal linebreak
setlocal nolisp
setlocal nolist
setlocal nomacmeta
setlocal makeprg=
setlocal matchpairs=(:),{:},[:]
setlocal modeline
setlocal modifiable
setlocal nrformats=octal,hex
set number
setlocal number
setlocal numberwidth=4
setlocal omnifunc=xmlcomplete#CompleteTags
setlocal path=
setlocal nopreserveindent
setlocal nopreviewwindow
setlocal quoteescape=\\
setlocal noreadonly
setlocal norelativenumber
setlocal norightleft
setlocal rightleftcmd=search
setlocal noscrollbind
setlocal shiftwidth=4
setlocal noshortname
setlocal smartindent
setlocal softtabstop=4
setlocal nospell
setlocal spellcapcheck=[.?!]\\_[\\])'\"\	\ ]\\+
setlocal spellfile=
setlocal spelllang=en
setlocal statusline=%{lightline#link()}%#LightLineLeft_inactive_0#%(\ %{lightline#function(\"MyFilename\")}\ %)%#LightLineLeft_inactive_0_1#‚ÆÄ%#LightLineMiddle_inactive#%=%#LightLineRight_inactive_1_2#‚ÆÇ%#LightLineRight_inactive_1#%(\ %3p%%\ %)%#LightLineRight_inactive_0_1#‚ÆÇ%#LightLineRight_inactive_0#%(\ %3l:%-2v\ %)
setlocal suffixesadd=.java,.xml,.9.png,.png,.py,.xml,.png,.9.png
setlocal noswapfile
setlocal synmaxcol=3000
if &syntax != 'xml'
setlocal syntax=xml
endif
setlocal tabstop=4
setlocal tags=
setlocal textwidth=0
setlocal thesaurus=
setlocal noundofile
setlocal winfixheight
setlocal nowinfixwidth
setlocal wrap
setlocal wrapmargin=0
let s:l = 7 - ((3 * winheight(0) + 7) / 15)
if s:l < 1 | let s:l = 1 | endif
exe s:l
normal! zt
7
normal! 011l
wincmd w
wincmd =
if exists('s:wipebuf')
  silent exe 'bwipe ' . s:wipebuf
endif
unlet! s:wipebuf
set winheight=1 winwidth=20 shortmess=filnxtToO
let s:sx = expand("<sfile>:p:r")."x.vim"
if file_readable(s:sx)
  exe "source " . fnameescape(s:sx)
endif
let &so = s:so_save | let &siso = s:siso_save
doautoall SessionLoadPost
unlet SessionLoad
" vim: set ft=vim :
