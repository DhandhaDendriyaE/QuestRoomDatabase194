private fun validateFields(): Boolean {
    val event = UiState.mahasiswaEvent
    val errorState = FormErrorState(
        nim = if (event.nim.isNotEmpty()) null else "nim tidak boleh kosong",
        nama = if (event.nama.isNotEmpty()) null else "nama tidak boleh kosong",
        JenisKelamin = if (event.nama.isNotEmpty()) null else "jenis kelamin tidak boleh kosong",
        alamat = if (event.alamat.isNotEmpty()) null else "alamat tidak boleh kosong",
        kelas = if (event.kelas.isNotEmpty()) null else "kelas tidak boleh kosong",

    )
}




fun saveData() {
    val currentEvent = uiState.mahasiswaEvent
    if (validateFields()){
        viewmodelScope.launch {
            try {
                repositoryMhs.insertMhs(currentEvent.toMahasiswaEntity())
                uiState = uiState.copy(
                    snackBarMessage = "Data Berhasil disimpan"
                    mahasiswaEvent = MahasiswaEven(),
                    isEntryValid = FormErrorState()
                )
            }catch (e: Exception){
                uiState =uiState.copy(
                    snackBarMessage = "Data Gagal disimpan"
                )
            }
        }
    }else {
        uiState = uiState.copy(
            snackBarMessage = "Input tidak valid, Periksa kembali data anda"
        )
    }
    }

    fun resetSnackBarMessage (){
        ui
    }
}
