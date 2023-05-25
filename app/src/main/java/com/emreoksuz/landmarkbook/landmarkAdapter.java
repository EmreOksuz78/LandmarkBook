package com.emreoksuz.landmarkbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.emreoksuz.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

//Adapter arasına RecyclerView.Adapter in içine açtığımız LandmarkHolder sınıfını yazıyoruz.
public class landmarkAdapter extends RecyclerView.Adapter<landmarkAdapter.landmarkHolder> {


    ArrayList<Landmark> landmarkArrayList;

    public landmarkAdapter(ArrayList<Landmark> landmarkArrayList) {
        this.landmarkArrayList = landmarkArrayList;
    }

    @NonNull
    @Override
    public landmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Buradaki context yerine bağlanacağı yeri yazmamız gerekiyor,bağlanacağı yer ise parent.getContext'tir.
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new landmarkHolder(recyclerRowBinding);
        //Binding i bağlicaz
        //XML burda bağlanıcak

    }

    @Override
    public void onBindViewHolder(@NonNull landmarkHolder holder, int position) {

        //Bu bölüm ViewHolder sınıfı ile bağlandığında neler olucağını yazdığımız kısım
        //Layout içinde verilerin gösterileceği kısım

        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        //itemView dediğimizde her bir elemanı elde edebiliyoruz
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(holder.itemView.getContext(),DetailsActivity.class);

                //Burada position kısmında hata veriyor ise Landmark sınıfını Serializable a impleme etmemiz gerekiyor.
                intent.putExtra("landmark", landmarkArrayList.get(position));
                holder.itemView.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
        //return kısmına landmarkArraylist i getiremeyeceğimizden dolayı bunu bir parametre olarak isteyeceğiz.
        //Sonra landmarkArraylist.size diyerek bunu bağlayabiliriz
        //Getireceğimiz item sayısı
    }

    public class landmarkHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;


        public landmarkHolder(RecyclerRowBinding binding) {
            //Parametre olarak verdiğimiz binding i bağlayabilmek için

            super(binding.getRoot());
            this.binding = binding;
        }
        //RecyclerView ile extends ediyoruz.
        //Adapter u yazma sebebimiz Layout ile buradaki kodları birbirine bağlayıp kullanıcıya göstermek

    }

}
