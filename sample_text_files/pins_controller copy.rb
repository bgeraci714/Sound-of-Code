class PinsController < ApplicationController
  before_action :set_pin, only: [:show, :edit, :update, :destroy]

  #make sure that user is authenticated before they can do the below actions
  # can do authenticate_user!, only: [:new, :create, :edit, ...]
  before_action :authenticate_user!, except: [:index, :show]

  before_action :correct_user, only: [:edit, :update, :destroy]

  def index
    @pins = Pin.all.order("created_at DESC").paginate(:page => params[:page], :per_page => 16)
  end

  def show
  end

  def new
    @pin = current_user.pins.build
  end

  def edit
  end

  def create
    @pin = current_user.pins.build(pin_params)
    if @pin.save
      redirect_to @pin, notice: 'Pin was successfully created.'
    else
      render :new
    end
  end

  def update
    if @pin.update(pin_params)
      redirect_to @pin, notice: 'Pin was successfully updated.'
    else
      render :edit
    end
  end

  def destroy
    @pin.destroy
    redirect_to pins_url, notice: 'Pin was successfully destroyed.'
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_pin
      @pin = Pin.find(params[:id])
    end

    def correct_user
      @pin = current_user.pins.find_by(id: params[:id])
      # looks up pin through user and redirects here if it doesn't find it (if pin is nil)
      redirect_to pins_path, notice: "Not authorized to edit this pin" if @pin.nil?
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def pin_params
      params.require(:pin).permit(:description, :image)
    end
end