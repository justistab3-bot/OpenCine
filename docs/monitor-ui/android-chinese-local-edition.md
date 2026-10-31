# Android Simplified Chinese local edition

This task adds Android display copy for a local OpenPocketCine APK. The user
requested Android only and will report physical-device results. iOS and the
other consuming apps are outside this delivery; no app pin or upstream release
is moved by this worktree.

`Android/monitor-ui` provides exact English-key lookup through `operatorText`
and argument-preserving formatting through `operatorFormat`. Simplified Chinese
is selected through the existing `CopyLanguage` policy. English and missing
entries retain English text. Uppercase UI labels resolve through a precomputed
uppercase-key table.

The supplemental catalog covers camera-page headings and actions, settings,
monitor assists, gimbal controls, media browsing, playback and Multiview. Existing
camera-controls and appkit catalogs retain their translations and use the
supplemental catalog for missing display labels. Camera names, network names,
filenames, storage keys, choice values and protocol commands retain their
original identities. Picker and drum translations apply at presentation sites;
callbacks still receive the original option values.

This is a local Android-only parity exception. iOS localization, propagation to
OpenInstaCine/OpenZCine, upstream integration and physical verification remain
outside the request. The merge owner handles APK compilation and packaging;
physical validation is left to the user as requested. No automated tests were
added or run for this copy-only increment.
